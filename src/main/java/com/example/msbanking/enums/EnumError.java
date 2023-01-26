package com.example.msbanking.enums;

public enum EnumError {

    CUSTOMER_ALREADY_EXITS(500, "Customer already exits!"),

    CUSTOMER_NOT_FOUND(501, "Customer not found!"),

    INVALID_REQUEST_DATA(502, "Invalid request data!"),

    ACCOUNT_NOT_FOUND(503, "Account not found!"),

    ACCOUNT_ALREADY_EXITS(504, "Account already exits!"),

    IBAN_INVALID_REQUEST_DATA(505, "Iban invalid request data!"),

    CURRENCY_INVALID_REQUEST_DATA(506, "Currency invalid request data!"),

    ACCOUNT_NUMBER_INVALID_REQUEST_DATA(507, "Account number invalid request data!"),

    CUSTOMER_INVALID_REQUEST_DATA(508, "Customer invalid request data"),

    NAME_INVALID_REQUEST_DATA(509, "Name invalid request data!"),

    SURNAME_INVALID_REQUEST_DATA(510, "Surname invalid request data!"),

    FIN_INVALID_REQUEST_DATA(511, "Fin invalid request data!"),

    CARD_NOT_FOUND(512, "Card not found!"),

    ACCOUNT_INVALID_REQUEST_DATA(513, "Account Invalid request data!"),

    CARD_ALREADY_EXITS(514, "Card already exits!"),

    NOT_SUFFICIENT_BALANCE(515,"Not sufficient balance!");


    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    EnumError(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
