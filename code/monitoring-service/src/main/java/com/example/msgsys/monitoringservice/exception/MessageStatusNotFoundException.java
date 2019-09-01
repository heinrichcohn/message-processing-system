package com.example.msgsys.monitoringservice.exception;

public class MessageStatusNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -7267490150145936761L;

    public MessageStatusNotFoundException(String message){
        super(message);
    }
}
