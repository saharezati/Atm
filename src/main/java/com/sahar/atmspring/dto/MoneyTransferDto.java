package com.sahar.atmspring.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoneyTransferDto {
    @NotNull
    @NotBlank
    @Pattern(regexp = "^\\d{16}$")

    private String cardnumber1;

    @NotNull
    @NotBlank
    @Pattern(regexp = "^\\d{16}$")
    private String cardnumber2;

    @NotNull
    @Size(min=1)
    private Double amount;
}
