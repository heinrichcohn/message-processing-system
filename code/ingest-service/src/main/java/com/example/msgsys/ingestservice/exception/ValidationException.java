package com.example.msgsys.ingestservice.exception;

public class ValidationException extends RuntimeException {

    private static final long serialVersionUID = 1118334070223970903L;

    public ValidationException(String message) {
        super(message);
    }
}
