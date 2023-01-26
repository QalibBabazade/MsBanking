package com.example.msbanking.dto.responses;

import com.example.msbanking.enums.CurrencyEnum;
import com.example.msbanking.enums.StatusEnum;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CardResponse implements Serializable {

    private Long id;
    private String number;
    private BigDecimal balance;
    private CurrencyEnum currency;
    private StatusEnum status;
    private AccountResponse accountResponse;
    private Date createDate;
    private Date expireDate;

    /*public CardResponse() {
    }*/

  /*  public CardResponse(Card card) {

        this.id = card.getId();
        this.number = card.getNumber();
        this.balance = card.getBalance();
        this.currency = card.getCurrency();
        this.status = card.getStatus();
        this.account = card.getAccount();
        this.createDate = card.getCreateDate();
        this.expireDate = card.getExpireDate();

    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public AccountResponse getAccountResponse() {
        return accountResponse;
    }

    public void setAccountResponse(AccountResponse accountResponse) {
        this.accountResponse = accountResponse;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }
}
