package com.afrid.bank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CustomerExistsException extends RuntimeException {
    public CustomerExistsException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
