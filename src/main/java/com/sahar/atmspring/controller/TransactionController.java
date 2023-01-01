package com.sahar.atmspring.controller;

import com.sahar.atmspring.dto.TransactionDto;
import com.sahar.atmspring.entity.Transaction;
import com.sahar.atmspring.mapper.TransactionMapper;
import com.sahar.atmspring.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("transaction")
@RestController

public class TransactionController {
    private TransactionService transactionService;


    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;

    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionDto> findbyid(@PathVariable(name = "id") Long id) {
        TransactionDto transactionDto = transactionService.findbyid(id);
        return ResponseEntity.ok(transactionDto);
    }

    @GetMapping("/")
    public ResponseEntity<List<TransactionDto>> findall() {
        List<TransactionDto> transactionDto = transactionService.findall( );
        return ResponseEntity.ok(transactionDto);
    }

    @GetMapping("/{card_number}")
    public ResponseEntity<List<TransactionDto>> lastTenTransaction(@PathVariable(name = "card_number") String cardnumber) {
        List<TransactionDto>transactionDto= transactionService.lasttentransaction(cardnumber);
        return ResponseEntity.ok( transactionDto );
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Valid TransactionDto transactionDto) {
        transactionService.saveOrUpdate(transactionDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletbyid(@PathVariable(name = "id") Long id) {
        transactionService.deletebyid(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
