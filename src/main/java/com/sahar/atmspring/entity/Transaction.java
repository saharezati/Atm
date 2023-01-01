package com.sahar.atmspring.entity;

import com.sahar.atmspring.entity.enums.TransactionType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "transaction")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "amount", nullable = false)
    private Double amount;
    @Column(name = "transaction_type", nullable = false, columnDefinition = "enum('DEPOSIT','WITHDRAW')")
    private TransactionType transactionType;
    @Column(name = "date", nullable = false)
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "account_id",nullable = false)
    private Account account;

    public Transaction(Double amount, TransactionType transactionType) {
        this.date= LocalDate.now();
        this.amount = amount;
        this.transactionType = transactionType;

    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", transactionType=" + transactionType +
                ", date=" + date +
                '}';
    }
}
