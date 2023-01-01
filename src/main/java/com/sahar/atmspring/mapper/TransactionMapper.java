package com.sahar.atmspring.mapper;

import com.sahar.atmspring.dto.TransactionDto;
import com.sahar.atmspring.entity.Transaction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper extends BaesMapper<Transaction, TransactionDto> {
}
