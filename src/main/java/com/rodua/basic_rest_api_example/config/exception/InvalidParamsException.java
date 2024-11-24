package com.rodua.basic_rest_api_example.config.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvalidParamsException extends BaseException {
    public InvalidParamsException(String message, String details) {
        super(message, details);
    }
}
