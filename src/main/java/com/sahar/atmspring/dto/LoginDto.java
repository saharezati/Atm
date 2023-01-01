package com.sahar.atmspring.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

    @NotNull
    @NotBlank
    @Pattern(regexp = "^\\d{16}$")
    private String cardnumber;

    @NotNull
    @NotBlank
    public String password;
}
