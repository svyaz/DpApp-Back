package com.github.svyaz.dppointsservice.model;

import org.springframework.stereotype.Component;

@Component
public class ErrorInfo {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
