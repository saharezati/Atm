package com.sahar.atmspring.Exceptions;

import org.springframework.http.HttpStatus;

public class InvalidPasswordExceptions extends BaseException {
    public static final String massege="Invalid password Exception";

    public InvalidPasswordExceptions() {
        super(massege);
    }

    @Override
    protected HttpStatus httpStatus() {
        return HttpStatus.UNAUTHORIZED;
    }
}

