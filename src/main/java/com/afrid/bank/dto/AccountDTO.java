package com.afrid.bank.dto;

import lombok.Data;

@Data
public class AccountDTO {

    private Long accountNumber;
    private String accountType;
    private String branchAddress;
}
