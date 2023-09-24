package com.afrid.bank.dto;

import com.afrid.bank.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Data
public class CustomerDTO {

    private String name;
    private String email;
    private String mobileNumber;
    private AccountDTO accountDTO;
}
