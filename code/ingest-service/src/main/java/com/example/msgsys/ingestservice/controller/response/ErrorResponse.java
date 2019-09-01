package com.example.msgsys.ingestservice.controller.response;

import java.io.Serializable;

public class ErrorResponse implements Serializable {

    private static final long serialVersionUID = -6809110676960616859L;

    private String details;

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
