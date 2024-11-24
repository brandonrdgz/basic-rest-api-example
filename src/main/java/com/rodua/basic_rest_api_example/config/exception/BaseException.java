package com.rodua.basic_rest_api_example.config.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BaseException extends RuntimeException {
    protected final String message;
    protected final String details;
}
