package com.sahar.atmspring.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepositWithdrawDto {

    @NotNull
    @NotBlank
    @Pattern(regexp = "^\\d{16}$")
    private String cardnumber;

    @NotNull
    @Min(value = 1)
    private Double amount;
}

