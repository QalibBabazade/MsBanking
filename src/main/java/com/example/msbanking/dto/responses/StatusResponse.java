package com.example.msbanking.dto.responses;

import java.io.Serializable;

public class StatusResponse implements Serializable {

    private Integer code;
    private String message;

    public static final Integer STATUS_CODE = 1;
    public static final String STATUS_MESSAGE = "Success!";

    public StatusResponse() {
    }

    public StatusResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    public static StatusResponse getSuccessMessage() {
        return new StatusResponse(STATUS_CODE, STATUS_MESSAGE);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
}
