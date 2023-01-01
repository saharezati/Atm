package com.sahar.atmspring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Random;

@Entity
@Table(name = "card")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "cvv2", length = 4, nullable = false)
    private String cvv2;

    @Column(name = "card_number", nullable = false, unique = true, length = 16)
    private String cardNumber;

    @Column(name = "password", nullable = false, length = 30)
    private String password;

    @Column(name = "expaire_date", nullable = false)
    private LocalDate expireDate;
    private static final String PRE_FIX = "12345678";

    public Card(String password) {
        Random random = new Random( );
        this.cardNumber=PRE_FIX+random.nextInt(10000000,99999999);
        this.cvv2= String.valueOf(random.nextInt(1000,9999));
        this.expireDate=LocalDate.now().plusYears(5);
        this.password = password;
    }

    public boolean validate(String password) {
        return this.password.equals(password);
    }
}
