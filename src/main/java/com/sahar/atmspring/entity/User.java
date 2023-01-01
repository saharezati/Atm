package com.sahar.atmspring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="name",nullable = false,length = 20)
    private String name;
    @Column(name="lastname",nullable = false,length = 30)
    private String lastname;
    @Column(name="nationalcod",nullable = false,unique = true, length = 16)
    private String nationalcod;
    @Column(name ="age",nullable = false)
    private Integer age;
    @Column(name = "birthday",nullable = false)
    private LocalDate birthday;

    public User(String name, String lastname, String nationalcod, LocalDate birthday) {
        this.age=LocalDate.now( ).getYear( )-birthday.getYear();
        this.name = name;
        this.lastname = lastname;
        this.nationalcod = nationalcod;
        this.birthday = birthday;
    }
}
