package com.sahar.atmspring.Exceptions;


import org.springframework.http.HttpStatus;

public class InvalidinputException extends BaseException{
    public InvalidinputException(String message) {
        super(message);
    }

    @Override
    protected HttpStatus httpStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
