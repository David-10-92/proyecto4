package com.user_service_apio.user_service.exceptions;

import org.springframework.http.HttpStatus;

public class UserException extends RuntimeException{
    private HttpStatus status;

    public UserException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }
}
