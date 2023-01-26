package com.example.msbanking.dto.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class TransferAccountRequest implements Serializable {
    @JsonProperty("first")
    private String firstAccountIban;
    @JsonProperty("last")
    private String lastAccountIban;
    private Double amount;

    public String getFirstAccountIban() {
        return firstAccountIban;
    }

    public void setFirstAccountIban(String firstAccountIban) {
        this.firstAccountIban = firstAccountIban;
    }

    public String getLastAccountIban() {
        return lastAccountIban;
    }

    public void setLastAccountIban(String lastAccountIban) {
        this.lastAccountIban = lastAccountIban;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
