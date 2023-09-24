package com.afrid.bank.service.impl;

import com.afrid.bank.constants.AccountsConstants;
import com.afrid.bank.dto.AccountDTO;
import com.afrid.bank.dto.CustomerDTO;
import com.afrid.bank.entity.Accounts;
import com.afrid.bank.entity.Customer;
import com.afrid.bank.exception.CustomerExistsException;
import com.afrid.bank.exception.ResourceNotFoundException;
import com.afrid.bank.mapper.AccountMapper;
import com.afrid.bank.mapper.CustomerMapper;
import com.afrid.bank.repository.AccountsRepository;
import com.afrid.bank.repository.CustomerRepository;
import com.afrid.bank.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountsService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;

    /**
     * @param customerDTO
     */
    @Override
    public void createAccount(CustomerDTO customerDTO) {
        Optional<Customer> isCustomerExits = customerRepository.findByMobileNumber(customerDTO.getMobileNumber());
        if (isCustomerExits.isPresent()) {
            throw new CustomerExistsException("Customer already exists with given mobile number, Try with some other phone number "
            + customerDTO.getMobileNumber());
        }
        Customer customer = CustomerMapper.mapToCustomer(customerDTO, new Customer());
        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("Ananomous");
        Customer savedCustomer = customerRepository.save(customer);
        Accounts createdAccount = createAccount(savedCustomer);

        accountsRepository.save(createdAccount);
    }

    private Accounts createAccount (Customer customer) {
        Accounts accounts = new Accounts();
        accounts.setCustomerId(customer.getCustomerId());
        long accountNumber = 100000000L + new Random().nextInt(900000);
        accounts.setAccountNumber(accountNumber);
        accounts.setAccountType(AccountsConstants.SAVINGS);
        accounts.setBranchAddress(AccountsConstants.ADDRESS);
        accounts.setCreatedAt(LocalDateTime.now());
        accounts.setCreatedBy("Ananoumous");
        return accounts;
    }

    /**
     * @param mobileNumber
     * @return Customer account details based on mobile number
     */
    @Override
    public CustomerDTO fetchAccountDetails(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "mobile number", mobileNumber));

        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Account", "customer ID", customer.getCustomerId().toString()));

        CustomerDTO customerDTO = CustomerMapper.mapToCustomerDTO(customer, new CustomerDTO());
        customerDTO.setAccountDTO(AccountMapper.mapToAccountDTO(accounts,new AccountDTO()));
        return customerDTO;
    }

    /**
     * @param customerDTO
     * @return
     */
    @Override
    public boolean updateAccount(CustomerDTO customerDTO) {
        boolean isAccountUpdated = false;
        AccountDTO accountDTO = customerDTO.getAccountDTO();
        if(accountDTO != null) {
            Accounts accounts = accountsRepository.findById(accountDTO.getAccountNumber())
                    .orElseThrow(() -> new ResourceNotFoundException("Account", "account Number", accountDTO.getAccountNumber().toString()));

            Accounts updatedAccount = AccountMapper.mapToAccount(accountDTO, accounts);
            accountsRepository.save(updatedAccount);

            Customer customer = customerRepository.findById(updatedAccount.getCustomerId())
                    .orElseThrow(() -> new ResourceNotFoundException("Customer", "customer Id", updatedAccount.getCustomerId().toString()));

            CustomerMapper.mapToCustomer(customerDTO,customer);
            customerRepository.save(customer);
            isAccountUpdated = true;
        }
        return isAccountUpdated;
    }

    /**
     * @param mobileNumber
     * @return
     */
    @Override
    public boolean deleteAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("customer", "mobile number", mobileNumber));

       // Optional<Accounts> accounts = accountsRepository.findByCustomerId(customer.getCustomerId());
        //accounts.ifPresent(accountInfo -> accountsRepository.deleteById(accountInfo.getAccountNumber()));
        accountsRepository.deleteByCustomerId(customer.getCustomerId());
        customerRepository.deleteById(customer.getCustomerId());
        return true;
    }


}
