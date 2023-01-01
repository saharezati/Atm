package com.sahar.atmspring.repository;


import com.sahar.atmspring.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card,Long> {
    Optional<Card>findByCardNumber(String cardnumber);

}
