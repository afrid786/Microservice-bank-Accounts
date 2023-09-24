package com.afrid.bank.mapper;

import com.afrid.bank.dto.AccountDTO;
import com.afrid.bank.entity.Accounts;

public class AccountMapper {

    public static AccountDTO mapToAccountDTO (Accounts account, AccountDTO accountDTO) {
        accountDTO.setAccountNumber(account.getAccountNumber());
        accountDTO.setAccountType(account.getAccountType());
        accountDTO.setBranchAddress(account.getBranchAddress());
        return accountDTO;
    }

    public static Accounts mapToAccount (AccountDTO accountDTO, Accounts accounts) {
        accounts.setAccountNumber(accountDTO.getAccountNumber());
        accounts.setAccountType(accountDTO.getAccountType());
        accounts.setBranchAddress(accountDTO.getBranchAddress());
        return accounts;
    }


}
