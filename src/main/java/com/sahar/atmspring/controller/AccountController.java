package com.sahar.atmspring.controller;

import com.sahar.atmspring.dto.*;
import com.sahar.atmspring.entity.Account;
import com.sahar.atmspring.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("account")
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @GetMapping
    public ResponseEntity<List<AccountDto>>findall(){
        List<AccountDto>accountDto=accountService.findall();
        return ResponseEntity.ok( accountDto );
    }
    @GetMapping("/{id}")
    public  ResponseEntity <AccountDto>findbyid(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok( accountService.findbyid(id) );
    }
    @GetMapping
    public ResponseEntity<AccountDto>findbycardnumber(@RequestParam(name = "card_number")String cardnumber){
        return ResponseEntity.ok( accountService.findByCardNumber(cardnumber) );
    }
    @PostMapping(name = "/login")
        public ResponseEntity<AccountDto> login (@RequestBody @Valid LoginDto loginDto){
        return ResponseEntity.ok (accountService.login(loginDto)) ;
    }
    @PostMapping(name = "")
    public ResponseEntity<AccountDto>save(@RequestBody @Valid AccountDto accountDto){
        return ResponseEntity.ok (accountService.saveOrUpdate(accountDto));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deletebyid(@PathVariable(name = "id")Long id){
        accountService.deletebyid(id);
        return new  ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/transfer")
    public ResponseEntity<Void>transfermony(@RequestBody @Valid MoneyTransferDto moneyTransferDto){
        accountService.moneyTransfer(moneyTransferDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/deposit")
    public ResponseEntity<Void>deposit(@RequestBody @Valid DepositWithdrawDto depositWithdrawDto) {
        accountService.deposit(depositWithdrawDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/withdraw")
    public ResponseEntity<Void>withdraw(@RequestBody @Valid DepositWithdrawDto depositWithdrawDto) {
        accountService.withdraw(depositWithdrawDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
