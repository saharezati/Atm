package com.sahar.atmspring.service.impl;

import com.sahar.atmspring.Exceptions.InvalidPasswordExceptions;
import com.sahar.atmspring.Exceptions.NotfoundException;
import com.sahar.atmspring.dto.AccountDto;
import com.sahar.atmspring.dto.DepositWithdrawDto;
import com.sahar.atmspring.dto.LoginDto;
import com.sahar.atmspring.dto.MoneyTransferDto;
import com.sahar.atmspring.entity.Account;
import com.sahar.atmspring.mapper.AccountMapper;
import com.sahar.atmspring.repository.AccountRepository;
import com.sahar.atmspring.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public AccountServiceImpl(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public AccountDto saveOrUpdate(AccountDto accountDto) {

        Account account = accountMapper.toEntity(accountDto);
        return accountMapper.toDto(accountRepository.save(account));
    }

    @Override
    public AccountDto findbyid(long id) {
        return accountMapper.toDto(accountRepository.findById(id).orElseThrow(() -> {
            throw new NotfoundException("account not found");
        }));
    }

    @Override
    public List<AccountDto> findall() {
        return accountMapper.toDto(accountRepository.findAll( ));
    }


    @Override
    public void deletebyid(long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public void delete(AccountDto accountDto) {
        accountRepository.delete(accountMapper.toEntity(accountDto));
    }


    @Override
    public AccountDto findByCardNumber(String cardnumber) {
        return accountMapper.toDto(accountRepository.findByCard_CardNumber(cardnumber).orElseThrow(() -> {
            throw new NotfoundException("account not found");
        }));
    }

    @Override
    public AccountDto login(LoginDto dto) {
        Account account = accountRepository.findByCard_CardNumber(dto.getCardnumber( )).orElseThrow(() -> {
            throw new NotfoundException("account not found");

        });
        if (account.getCard( ).validate(dto.getPassword( )))
            return accountMapper.toDto(account);
        else
            throw new InvalidPasswordExceptions( );
    }


    @Override
    public void moneyTransfer(MoneyTransferDto moneyTransferDto) {
        List<Account> accounts = new ArrayList<>( );
        accountRepository.findByCard_CardNumber(moneyTransferDto.getCardnumber1( )).ifPresentOrElse(account -> {
            Account account2 = accountRepository.findByCard_CardNumber(moneyTransferDto.getCardnumber2( )).orElseThrow(() -> {
                throw new NotfoundException("account destiny not found");
            });
            account.withdraw(moneyTransferDto.getAmount( ));
            account2.deposit(moneyTransferDto.getAmount( ));
            accounts.add(account);
            accounts.add(account2);

            accountRepository.saveAll(accounts);
        }, () -> {
            throw new NotfoundException("account origin not found");

        });
    }

    @Override
    public void withdraw(DepositWithdrawDto depositWithdrawDto) {
        Account account=accountRepository.findByCard_CardNumber(depositWithdrawDto.getCardnumber()).orElseThrow(() ->{
            throw new NotfoundException("account not found");
        });
        account.withdraw(depositWithdrawDto.getAmount( ));
        accountRepository.save(account);

    }

    @Override
    public void deposit(DepositWithdrawDto depositWithdrawDto) {
        Account account=accountRepository.findByCard_CardNumber(depositWithdrawDto.getCardnumber()).orElseThrow(() ->{
            throw new NotfoundException("account not found");
        });
        account.deposit(depositWithdrawDto.getAmount( ));
        accountRepository.save(account);

    }

}
