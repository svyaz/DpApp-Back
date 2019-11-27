package com.github.svyaz.dppointsservice.controller;

import com.github.svyaz.dppointsservice.model.ErrorInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class ErrorController {
    private ErrorInfo errorInfo;

    public ErrorController(ErrorInfo errorInfo) {
        this.errorInfo = errorInfo;
    }

    // Validation errors
    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<ErrorInfo> handleConstraintViolationException(ConstraintViolationException e) {
        errorInfo.setMessage("Validation error: " + e.getMessage());
        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }

    // Not found
    @ExceptionHandler({NoHandlerFoundException.class})
    public ResponseEntity<ErrorInfo> handleNoHandlerFoundException(NoHandlerFoundException e) {
        errorInfo.setMessage("Not found. " + e.getMessage());
        return new ResponseEntity<>(errorInfo, HttpStatus.NOT_FOUND);
    }

    // Some other errors
    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorInfo> handleException(Exception e) {
        errorInfo.setMessage("Exception: " + e.getMessage());
        return new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
