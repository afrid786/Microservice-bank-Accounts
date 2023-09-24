package com.afrid.bank.exception;

import com.afrid.bank.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerExistsException.class)
    public ResponseEntity<ErrorResponseDTO> handleCustomerExistsException (CustomerExistsException customerExistsException, WebRequest webRequest) {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(webRequest.getDescription(false),
                HttpStatus.BAD_REQUEST,
                customerExistsException.getMessage(),
                LocalDateTime.now());
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errorResponseDTO);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleCustomerExistsException (ResourceNotFoundException resourceNotFoundException, WebRequest webRequest) {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(webRequest.getDescription(false),
                HttpStatus.BAD_REQUEST,
                resourceNotFoundException.getMessage(),
                LocalDateTime.now());
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errorResponseDTO);
    }

}
