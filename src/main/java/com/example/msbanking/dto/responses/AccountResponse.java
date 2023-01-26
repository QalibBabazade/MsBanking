package com.example.msbanking.dto.responses;
import com.example.msbanking.enums.CurrencyEnum;
import com.example.msbanking.enums.StatusEnum;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class AccountResponse implements Serializable {

    private Long id;
    private String iban;
    private String number;
    private CurrencyEnum currency;
    private StatusEnum status;
    private BigDecimal balance;
    private CustomerResponse customerResponse;
    private List<CardResponse> cardResponse;
    private Date createDate;

    public CustomerResponse getCustomerResponse() {
        return customerResponse;
    }

    public void setCustomerResponse(CustomerResponse customerResponse) {
        this.customerResponse = customerResponse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public CurrencyEnum getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyEnum currency) {
        this.currency = currency;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }



    public List<CardResponse> getCardResponse() {
        return cardResponse;
    }

    public void setCardResponse(List<CardResponse> cardResponse) {
        this.cardResponse = cardResponse;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
