package com.sahar.atmspring.dto;

import com.sahar.atmspring.entity.enums.AccountType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private Long id;

    @NotNull
    @NotBlank
    @Pattern(regexp = "^\\d{10}$")
    private String accountnumber;

    @NotNull
    @NotBlank
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?\\d)(?=.*?[#?!@$ %^&*-]).{5,}$")
    private String password;

    @NotNull
    @Size(min=0)
    private Double balance;

    @NotNull
    private AccountType accountType;

    @NotNull
    private UserDto user;

    @NotNull
    private CardDto card;
    private List<TransactionDto>transactions;

}
