package com.afrid.bank.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(name = "Customer")
public class CustomerDTO {

    @NotEmpty(message = "Name can't be empty")
    @Size(min = 5,max = 30,message = "The length of the name should be between 5 and 30")
    private String name;

    @NotEmpty(message = "Email can't be empty")
    @Email(message = "Email should be valid")
    private String email;

    @Pattern(regexp = "($|[0-9]{10})",message = "Mobile  number is not valid")
    private String mobileNumber;
    private AccountDTO accountDTO;
}
