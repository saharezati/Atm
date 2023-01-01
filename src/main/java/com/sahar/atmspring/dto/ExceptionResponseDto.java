package com.sahar.atmspring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ExceptionResponseDto {
    private LocalDateTime time;
    private Integer status;
    private String masseg;

}
