package com.sahar.atmspring.Exceptions;

import com.sahar.atmspring.dto.ExceptionResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(value = BaseException.class)
    public ResponseEntity<ExceptionResponseDto> baseExceptionHandler(BaseException baseException){
        return new ResponseEntity<>(new ExceptionResponseDto().setMasseg(baseException.getMessage())
                .setStatus(baseException.httpStatus().value())
                .setTime(LocalDateTime.now())
        ,baseException.httpStatus());
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public ResponseEntity<ExceptionResponseDto> ExceptionHandler(BaseException exception){
        return new ResponseEntity<>(new ExceptionResponseDto().setMasseg(exception.getMessage())
                .setStatus(exception.httpStatus().value())
                .setTime(LocalDateTime.now())
                ,exception.httpStatus());
    }
}
