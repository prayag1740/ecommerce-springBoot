package com.example.ecommerce.config;

public class ApiResponse<T> {

    private final int statusCode = 0;
    private T data ;

    public ApiResponse(T data) {
        this.data = data ;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
