package com.example.msbanking.enums;

public enum StatusEnum {
    NONE(0),
    ACTIVE(1),
    BLOCKED(2);

    private Integer value;

    private StatusEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

}
