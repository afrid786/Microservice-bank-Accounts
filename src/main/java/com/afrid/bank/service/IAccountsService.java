package com.afrid.bank.service;

import com.afrid.bank.dto.CustomerDTO;
import org.springframework.stereotype.Service;

public interface IAccountsService {

    /**
     * @param customerDTO
     */
     void createAccount (CustomerDTO customerDTO);


    /**
     * @param mobileNumber
     * @return Customer account details based on mobile number
     */
     CustomerDTO fetchAccountDetails (String mobileNumber);

    /**
     * @param customerDTO
     * @return
     */
     boolean updateAccount (CustomerDTO customerDTO);

    /**
     * @param mobileNumber
     * @return
     */
    boolean deleteAccount (String mobileNumber);


}
