package com.afrid.bank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String exceptionMessage,String fieldName, String fieldValue) {
        super(String.format("%s is not present with %s : %s",exceptionMessage,fieldName,fieldValue));
    }
}
