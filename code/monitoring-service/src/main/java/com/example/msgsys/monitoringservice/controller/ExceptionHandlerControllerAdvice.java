package com.example.msgsys.monitoringservice.controller;

import com.example.msgsys.monitoringservice.controller.response.ErrorResponse;
import com.example.msgsys.monitoringservice.exception.MessageStatusNotFoundException;
import com.example.msgsys.monitoringservice.exception.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity handleValidationException(ValidationException ve) {
        return new ResponseEntity<>(getErrorResponse(ve.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MessageStatusNotFoundException.class)
    public ResponseEntity handleValidationException(MessageStatusNotFoundException mnfe) {
        return new ResponseEntity<>(getErrorResponse(mnfe.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception e) {
        return new ResponseEntity<>(getErrorResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ErrorResponse getErrorResponse(String details) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setDetails(details);
        return errorResponse;
    }
}
