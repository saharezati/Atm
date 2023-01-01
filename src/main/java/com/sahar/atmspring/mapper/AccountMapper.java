package com.sahar.atmspring.mapper;

import com.sahar.atmspring.dto.AccountDto;
import com.sahar.atmspring.entity.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper extends BaesMapper<Account, AccountDto> {
}
