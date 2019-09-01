package com.example.msgsys.ingestservice.controller.request;

import java.io.Serializable;

public class IngestMessageRequest implements Serializable {

    private static final long serialVersionUID = -8328120340784273891L;
    private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
