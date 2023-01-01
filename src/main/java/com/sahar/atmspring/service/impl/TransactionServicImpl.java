package com.sahar.atmspring.service.impl;

import com.sahar.atmspring.Exceptions.NotfoundException;
import com.sahar.atmspring.dto.TransactionDto;
import com.sahar.atmspring.entity.Transaction;
import com.sahar.atmspring.mapper.TransactionMapper;
import com.sahar.atmspring.repository.TranactionRepository;
import com.sahar.atmspring.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServicImpl implements TransactionService {
    private TranactionRepository tranactionRepository;

    private final TransactionMapper transactionMapper;

    @Autowired
    public TransactionServicImpl(TranactionRepository tranactionRepository, TransactionMapper transactionMapper) {
        this.tranactionRepository = tranactionRepository;
        this.transactionMapper = transactionMapper;
    }
    @Override
    public void saveOrUpdate(TransactionDto transactionDto){
        tranactionRepository  .save(transactionMapper.toEntity(transactionDto));
    }
    @Override
    public TransactionDto findbyid(long id){
        return transactionMapper.toDto(tranactionRepository.findById(id).orElseThrow( ()->{
            throw new NotfoundException("transaction not found");
        } ));

    }
    @Override
    public List<TransactionDto> findall(){
        return transactionMapper.toDto(tranactionRepository.findAll());
    }
    @Override
    public  void  deletebyid(long id){
        tranactionRepository .deleteById(id);
    }
    @Override
    public void delete(TransactionDto transactionDto){
        tranactionRepository.delete(transactionMapper.toEntity(transactionDto));
    }
    @Override
    public List<TransactionDto>lasttentransaction(String cardnumber){
        return transactionMapper.toDto(tranactionRepository.findByAccount_Card_CardNumberOrderByDateDesc(cardnumber, PageRequest.of(0,10)).getContent());
    }

}
