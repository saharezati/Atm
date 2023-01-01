package com.sahar.atmspring.repository;

import com.sahar.atmspring.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface TranactionRepository extends JpaRepository<Transaction, Long> {
    Page<Transaction> findByAccount_Card_CardNumberOrderByDateDesc(String cardnumber, Pageable pageable);


}
