package com.example.msgsys.monitoringservice.exception;

public class ValidationException extends RuntimeException {

    private static final long serialVersionUID = 5322749997003492178L;

    public ValidationException(String message) {
        super(message);
    }

}
