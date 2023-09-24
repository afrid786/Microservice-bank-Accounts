package com.afrid.bank.mapper;

import com.afrid.bank.dto.CustomerDTO;
import com.afrid.bank.entity.Customer;

public class CustomerMapper {

    public static CustomerDTO mapToCustomerDTO (Customer customer, CustomerDTO customerDTO) {
        customerDTO.setName(customer.getName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setMobileNumber(customer.getMobileNumber());
        return customerDTO;
    }
    public static Customer mapToCustomer(CustomerDTO customerDto, Customer customer) {
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNumber(customerDto.getMobileNumber());
        return customer;
    }
}
