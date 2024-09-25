package com.example.ecommerce.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {

    private final  HttpStatus statusCode ;
    private final Integer errorCode ;

    public CustomException(HttpStatus statusCode, Integer errorCode, String message) {
        super(message);
        this.statusCode = statusCode;
        this.errorCode = errorCode ;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public Integer getErrorCode() {
        return errorCode;
    }
}
