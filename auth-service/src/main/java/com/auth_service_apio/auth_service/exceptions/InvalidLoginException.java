package com.auth_service_apio.auth_service.exceptions;

public class InvalidLoginException extends Exception{
    public InvalidLoginException(String message) {
        super(message);
    }
}
