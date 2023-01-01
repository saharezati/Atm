package com.sahar.atmspring.repository;

import com.sahar.atmspring.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

    Optional<Account>findByCard_CardNumber(String cardnumber);
}
