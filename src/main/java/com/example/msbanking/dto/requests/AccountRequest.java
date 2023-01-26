package com.example.msbanking.dto.requests;

import com.example.msbanking.entities.Card;
import com.example.msbanking.entities.Customer;
import com.example.msbanking.enums.CurrencyEnum;
import com.example.msbanking.enums.StatusEnum;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class AccountRequest implements Serializable {

    private String iban;
    private String number;
    private CurrencyEnum currency;
    private StatusEnum status;
    private BigDecimal balance;
    private Customer customer;
    private List<Card> card;


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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Card> getCard() {
        return card;
    }

    public void setCard(List<Card> card) {
        this.card = card;
    }
}
