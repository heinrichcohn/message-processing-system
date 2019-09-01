package com.example.msgsys.ingestservice.controller.response;

import java.io.Serializable;

public class IngestMessageResponse implements Serializable {

    private static final long serialVersionUID = -8328120340784273891L;
    private String messageId;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}
