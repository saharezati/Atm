package com.sahar.atmspring.Exceptions;

import org.springframework.http.HttpStatus;

public class InvalidAmountException extends BaseException {
    public static final String masseg="invalid amount";
    public InvalidAmountException() {
        super(masseg);
    }

    @Override
    protected HttpStatus httpStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
