package com.example.ecommerce.dao;

public class ErrorInfo {
    private final Integer statusCode ;
    private final String errorMessage ;

    public ErrorInfo(Integer statusCode, String errorMessage) {
        this.statusCode = statusCode;
        this.errorMessage = errorMessage;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
