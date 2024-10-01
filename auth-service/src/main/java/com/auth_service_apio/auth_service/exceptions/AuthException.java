package com.auth_service_apio.auth_service.exceptions;

import org.springframework.http.HttpStatus;

public class AuthException extends RuntimeException{
    private HttpStatus status;

    public AuthException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }
}
