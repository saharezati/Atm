package com.sahar.atmspring.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class TransactionDto {
    private Long id;

    @NotNull
    @Min(value = 1)
    private Double amount;

    @NotNull
    @PastOrPresent
    private LocalDate date;


}
