package com.sahar.atmspring.entity;

import com.sahar.atmspring.Exceptions.InvalidAmountException;
import com.sahar.atmspring.entity.enums.AccountType;
import com.sahar.atmspring.entity.enums.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "account_number", nullable = false, unique = true, length = 16)
    private String accountnumber;

    @Column(name = "password", nullable = false, length = 8)
    private String password;

    @Column(name = "balance", nullable = false, columnDefinition = "double default 100")
    private Double balance;

    @Column(name = "account_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id", nullable = false)
    private Card card;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Transaction> transactions;

    public Account(String password, AccountType accountType, User user) {
        Random random=new Random();
        this.accountnumber=String.valueOf(random.nextInt(10000000,99999999));
        this.balance=100d;
        this.card=new Card(password);
        this.transactions=new ArrayList<>();
        this.password = password;
        this.accountType = accountType;
        this.user = user;
    }

    public void deposit(Double amount) {
        this.balance += amount;
        Transaction transaction = new Transaction(amount, TransactionType.DEPOSIT);
        if (Objects.isNull(transactions))
            transactions = new ArrayList<>( );
        transactions.add(transaction);


    }

    public void withdraw(Double amount) {
        if (amount < this.balance) {
            this.balance -= amount;
            Transaction transaction = new Transaction(amount, TransactionType.WITHDRAW);
            if (Objects.isNull(transactions))
                transactions = new ArrayList<>( );
            transactions.add(transaction);

        } else {
            throw new InvalidAmountException( );
        }
    }
}