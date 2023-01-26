package com.example.msbanking.dto.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class TransferCardRequest implements Serializable {

    @JsonProperty(value = "first")
    private String firstCardNumber;
    @JsonProperty(value = "last")
    private String lastCardNumber;
    private Double amount;

    public String getFirstCardNumber() {
        return firstCardNumber;
    }

    public void setFirstCardNumber(String firstCardNumber) {
        this.firstCardNumber = firstCardNumber;
    }

    public String getLastCardNumber() {
        return lastCardNumber;
    }

    public void setLastCardNumber(String lastCardNumber) {
        this.lastCardNumber = lastCardNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
