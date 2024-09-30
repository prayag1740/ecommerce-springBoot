package com.example.ecommerce.config;
import java.util.Optional;

public class ApiResponse<T> {

    private final int statusCode = 0;
    private Optional<T> data ;

    public ApiResponse(T data) {
        this.data = Optional.ofNullable(data) ;
    }
    public int getStatusCode() {
        return statusCode;
    }

    public Optional<T> getData() {
        return data;
    }
}
