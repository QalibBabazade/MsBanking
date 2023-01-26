package com.example.msbanking.dto.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class StatusAllResponse implements Serializable {

    @JsonProperty(value = "status")
    private StatusResponse statusResponse;

    public StatusResponse getStatusResponse() {
        return statusResponse;
    }

    public void setStatusResponse(StatusResponse statusResponse) {
        this.statusResponse = statusResponse;
    }

    public StatusAllResponse() {
    }

    public StatusAllResponse(StatusResponse statusResponse) {
        this.statusResponse = statusResponse;
    }
}
