package com.example.msbanking.util;

import com.example.msbanking.dto.requests.AccountRequest;
import com.example.msbanking.dto.requests.CardRequest;
import com.example.msbanking.dto.requests.CustomerRequest;
import com.example.msbanking.entities.Account;
import com.example.msbanking.entities.Customer;
import com.example.msbanking.enums.EnumAvailableStatus;
import com.example.msbanking.enums.EnumError;
import com.example.msbanking.exception.BaseException;
import com.example.msbanking.repository.AccountRepository;
import com.example.msbanking.repository.CustomerRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Objects;

@Component("utility")
public class Utility {

    private final CustomerRepository customerRepository;

    private final AccountRepository accountRepository;

    public Utility(CustomerRepository customerRepository, AccountRepository accountRepository) {
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
    }

    public void checkAccountRequestData(AccountRequest accountRequest) {

        if (Objects.isNull(accountRequest.getIban()) || accountRequest.getIban().length() > 30) {
            throw new BaseException(EnumError.IBAN_INVALID_REQUEST_DATA.getCode(), EnumError.IBAN_INVALID_REQUEST_DATA.getMessage());
        }
        if (Objects.isNull(accountRequest.getNumber()) || accountRequest.getNumber().length() > 20) {
            throw new BaseException(EnumError.ACCOUNT_NUMBER_INVALID_REQUEST_DATA.getCode(), EnumError.ACCOUNT_NUMBER_INVALID_REQUEST_DATA.getMessage());
        }
        if (Objects.isNull(accountRequest.getCustomer().getId())) {
            throw new BaseException(EnumError.CUSTOMER_INVALID_REQUEST_DATA.getCode(), EnumError.CUSTOMER_INVALID_REQUEST_DATA.getMessage());
        }
        if (Objects.isNull(accountRequest.getCurrency().getValue())) {
            throw new BaseException(EnumError.CURRENCY_INVALID_REQUEST_DATA.getCode(), EnumError.CURRENCY_INVALID_REQUEST_DATA.getMessage());
        }

    }

    public void checkCustomer(Long id) {
        Customer customer = customerRepository.findCustomerByIdAndActive(id, EnumAvailableStatus.ACTIVE.getValue());
        if (Objects.isNull(customer)) {
            throw new BaseException(EnumError.CUSTOMER_NOT_FOUND.getCode(), EnumError.CUSTOMER_NOT_FOUND.getMessage());
        }


    }


    public void checkCustomerRequestData(CustomerRequest customerRequest) {

        if (Objects.isNull(customerRequest.getName()) || customerRequest.getName().length() > 20) {
            throw new BaseException(EnumError.NAME_INVALID_REQUEST_DATA.getCode(), EnumError.NAME_INVALID_REQUEST_DATA.getMessage());
        }
        if (Objects.isNull(customerRequest.getSurname()) || customerRequest.getSurname().length() > 20) {
            throw new BaseException(EnumError.SURNAME_INVALID_REQUEST_DATA.getCode(), EnumError.SURNAME_INVALID_REQUEST_DATA.getMessage());
        }
        if (Objects.isNull(customerRequest.getFin()) || customerRequest.getFin().length() > 7) {
            throw new BaseException(EnumError.FIN_INVALID_REQUEST_DATA.getCode(), EnumError.FIN_INVALID_REQUEST_DATA.getMessage());
        }
    }

    public void checkCardRequestData(CardRequest cardRequest) {

        Account account = accountRepository.findAccountByIdAndActive(cardRequest.getAccount().getId(),EnumAvailableStatus.ACTIVE.getValue());
        if (Objects.isNull(cardRequest.getNumber())) {
            throw new BaseException(EnumError.INVALID_REQUEST_DATA.getCode(), EnumError.INVALID_REQUEST_DATA.getMessage());
        }
        if (Objects.isNull(cardRequest.getCurrency())) {
            throw new BaseException(EnumError.CURRENCY_INVALID_REQUEST_DATA.getCode(), EnumError.CURRENCY_INVALID_REQUEST_DATA.getMessage());
        }
        if (Objects.isNull(cardRequest.getAccount().getId())) {
            throw new BaseException(EnumError.ACCOUNT_INVALID_REQUEST_DATA.getCode(), EnumError.ACCOUNT_INVALID_REQUEST_DATA.getMessage());
        }
        if(Objects.isNull(account)){
            throw new BaseException(EnumError.ACCOUNT_NOT_FOUND.getCode(), EnumError.ACCOUNT_NOT_FOUND.getMessage());
        }
    }

    public boolean checkBalance(BigDecimal balance, Double amount) {
        if(balance.doubleValue() < amount){
            return false;
        }
        return true;
    }

    public boolean checkBalance(BigDecimal cardBalance,BigDecimal accountBalance, Double amount) {
        if(cardBalance.doubleValue() < amount){
            return false;
        }else if(accountBalance.doubleValue() < amount){
            return false;
        }
        return true;
    }
}
