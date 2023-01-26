package com.example.msbanking.dto.requests;

import com.example.msbanking.entities.Account;
import com.example.msbanking.enums.CurrencyEnum;
import com.example.msbanking.enums.StatusEnum;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CardRequest implements Serializable {

    private String number;
    private BigDecimal balance;
    private CurrencyEnum currency;
    private StatusEnum status;
    private Account account;
    private Date expireDate;


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }
}
