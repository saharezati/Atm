package com.sahar.atmspring;

import com.sahar.atmspring.entity.Card;
import com.sahar.atmspring.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class AtmSpringApplication implements ApplicationRunner {

    @Autowired
    CardService cardService;

    public static void main(String[] args) {
        SpringApplication.run(AtmSpringApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        cardService.save(new Card(null,"8585","123456789","1234", LocalDate.now().plusYears(3)));
    }
}
