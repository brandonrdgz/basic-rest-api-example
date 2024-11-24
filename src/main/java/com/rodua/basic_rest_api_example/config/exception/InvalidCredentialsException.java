package com.rodua.basic_rest_api_example.config.exception;

public class InvalidCredentialsException extends BaseException {
    public InvalidCredentialsException(String details) {
        super("Invalid credendials", details);
    }
}
