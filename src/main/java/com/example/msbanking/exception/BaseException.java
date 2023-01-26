package com.example.msbanking.exception;

import com.example.msbanking.enums.EnumError;

public class BaseException extends RuntimeException{

    private Integer code;
    private String message;

    public static BaseException of (EnumError enumError){
        return new BaseException(enumError.getCode(), enumError.getMessage());

    }

    public BaseException() {
    }

    public BaseException(Integer code,String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
