package com.afrid.bank.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Schema(name = "Response JSON")
@Data
@AllArgsConstructor
public class ErrorResponseDTO {

    private String apiPath;
    private HttpStatus httpStatus;
    private String errorMessage;
    private LocalDateTime errorTime;
}
