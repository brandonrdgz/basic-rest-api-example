package com.rodua.basic_rest_api_example.config.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ForbiddenException extends BaseException {
    public ForbiddenException(String message, String details) {
        super(message, details);
    }
}
