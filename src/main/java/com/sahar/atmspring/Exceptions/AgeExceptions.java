package com.sahar.atmspring.Exceptions;

import org.springframework.http.HttpStatus;

public class  AgeExceptions  extends BaseException{
    private  static final String massage ="you are underage";

    public AgeExceptions() {super(massage);
    }

    @Override
    protected HttpStatus httpStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
