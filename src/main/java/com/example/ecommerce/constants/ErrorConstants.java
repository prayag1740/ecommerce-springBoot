package com.example.ecommerce.constants;

import com.example.ecommerce.dao.ErrorInfo;

public class ErrorConstants {

    public static ErrorInfo API_EXCEPTION = new ErrorInfo(1, "Api Exception");
    public static ErrorInfo BAD_REQUEST = new ErrorInfo(1, "Bad Request");

    //user
    public static ErrorInfo USER_NOT_FOUND = new ErrorInfo(2, "User does not exist");
    public static ErrorInfo USER_ROLE_ALREADY_EXISTS = new ErrorInfo(2, "User Role already exists");

}
