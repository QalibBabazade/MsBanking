package com.example.msbanking.enums;

public enum EnumTransferType {
    ACCOUNT_TO_ACCOUNT(1),
    ACCOUNT_TO_CARD(2),
    CARD_TO_ACCOUNT(3),
    CARD_TO_CARD(4);

    private Integer value;

    private EnumTransferType(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
