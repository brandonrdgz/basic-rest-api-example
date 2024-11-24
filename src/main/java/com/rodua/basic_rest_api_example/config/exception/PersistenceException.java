package com.rodua.basic_rest_api_example.config.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersistenceException extends BaseException {
    public PersistenceException(String message, String details) {
        super(message, details);
    }
}
