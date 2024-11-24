package com.rodua.basic_rest_api_example.config.exception;

public class NotFoundException extends BaseException {
    public NotFoundException(String message, String details) {
        super(message, details);
    }
}
