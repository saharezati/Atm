package com.sahar.atmspring.Exceptions;

import org.springframework.http.HttpStatus;

public class NotfoundException extends BaseException{
    public NotfoundException(String message) {
        super(message);
    }

    @Override
    protected HttpStatus httpStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
