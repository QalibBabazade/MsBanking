package com.example.msbanking.enums;

public enum CurrencyEnum {

    AZN(0),
    USD(1),
    EURO(2);

    private Integer value;

    private CurrencyEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

}
