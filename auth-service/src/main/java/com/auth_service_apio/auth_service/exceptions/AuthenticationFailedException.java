package com.auth_service_apio.auth_service.exceptions;

public class AuthenticationFailedException extends Exception{
    public AuthenticationFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
