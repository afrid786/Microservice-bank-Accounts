package com.afrid.bank.controller;


import com.afrid.bank.constants.AccountsConstants;
import com.afrid.bank.dto.CustomerDTO;
import com.afrid.bank.dto.ResponseDTO;
import com.afrid.bank.service.IAccountsService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class AccountController {

    private IAccountsService iAccountsService;

    @PostMapping(path = "/create")
    public ResponseEntity<ResponseDTO> createAccount (@Valid @RequestBody CustomerDTO customerDTO) {

        iAccountsService.createAccount(customerDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDTO(AccountsConstants.STATUS_200,AccountsConstants.MESSAGE_200));
    }

    @GetMapping(path = "/account")
    public ResponseEntity<CustomerDTO> fetchAccountDetails (@Pattern(regexp = "($|[0-9]{10})",message = "Mobile  number is not valid")
                                                                @RequestParam String mobileNumber) {
        CustomerDTO customerDTO = iAccountsService.fetchAccountDetails(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK)
                .body(customerDTO);

    }

    @PutMapping("/updateAccount")
    public ResponseEntity<ResponseDTO> updateAccountDetails (@Valid @RequestBody CustomerDTO customerDTO) {
        boolean isAccountUpdated = iAccountsService.updateAccount(customerDTO);
        if(isAccountUpdated) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDTO(AccountsConstants.STATUS_200,AccountsConstants.MESSAGE_200));
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(AccountsConstants.STATUS_500,AccountsConstants.MESSAGE_500));
        }
    }

    @DeleteMapping("/deleteAccount")
    public ResponseEntity<ResponseDTO> deleteAccount (@Pattern(regexp = "($|[0-9]{10})",message = "Mobile  number is not valid")
                                                          @RequestParam String mobileNumber) {
        boolean isAccountDeleted = iAccountsService.deleteAccount(mobileNumber);
        if(isAccountDeleted) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDTO(AccountsConstants.STATUS_200,AccountsConstants.MESSAGE_200));
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(AccountsConstants.STATUS_500,AccountsConstants.MESSAGE_500));
        }
    }


}
