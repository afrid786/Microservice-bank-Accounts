package com.afrid.bank.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(name = "Account")
public class AccountDTO {

    @NotEmpty(message = "AccountNumber can't be empty")
    @Pattern(regexp = "($|[0-9]{9})",message = "Account Number is not valid")
    private Long accountNumber;

    @NotEmpty(message = "AccountType can't be empty")
    private String accountType;

    @NotEmpty(message = "Branch address can't be empty")
    private String branchAddress;
}
