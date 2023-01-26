package com.example.msbanking.dto.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Response <T> implements Serializable {
    @JsonProperty(value = "response")
    private T t;
    @JsonProperty(value = "status")
    private StatusResponse statusResponse;


    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public StatusResponse getStatusResponse() {
        return statusResponse;
    }

    public void setStatusResponse(StatusResponse statusResponse) {
        this.statusResponse = statusResponse;
    }
}
