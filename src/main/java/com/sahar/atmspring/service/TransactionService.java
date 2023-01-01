package com.sahar.atmspring.service;

import com.sahar.atmspring.dto.TransactionDto;
import com.sahar.atmspring.entity.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionService {
    void saveOrUpdate(TransactionDto transactionDto);

    TransactionDto findbyid(long id);

    List<TransactionDto> findall();

    void  deletebyid(long id);

    void delete(TransactionDto transactionDto);

    List<TransactionDto>lasttentransaction(String cardnumber);
}
