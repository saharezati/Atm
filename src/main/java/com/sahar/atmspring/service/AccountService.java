package com.sahar.atmspring.service;

import com.sahar.atmspring.dto.AccountDto;
import com.sahar.atmspring.dto.DepositWithdrawDto;
import com.sahar.atmspring.dto.LoginDto;
import com.sahar.atmspring.dto.MoneyTransferDto;
import com.sahar.atmspring.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService  {
    AccountDto saveOrUpdate(AccountDto account);

    AccountDto findbyid(long id);

    List<AccountDto> findall();

    void deletebyid(long id);

    void delete(AccountDto accountDto);

    AccountDto findByCardNumber(String cardnumber);

    AccountDto login(LoginDto dto);

    void moneyTransfer(MoneyTransferDto moneyTransferDto);

    void withdraw(DepositWithdrawDto depositWithdrawDto);
    void deposit(DepositWithdrawDto depositWithdrawDto);

}
