package com.sahar.atmspring.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CardDto {
    private Long id;

    @NotNull
    @NotBlank
    @Pattern(regexp = "^\\d{3,4}$")
    private String cvv2;

    @NotNull
    @NotBlank
    @Pattern(regexp ="^\\d{16}$" )
    private String cardNumber;

    @NotBlank
    @NotNull
    private String password;

    @NotNull
    @FutureOrPresent
    private LocalDate expireDate;
}
