package com.example.api.API.ExceptionHandling;

public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}