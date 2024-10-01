package com.game_service_api.game_service.exceptions;

import org.springframework.http.HttpStatus;

public class GameException extends RuntimeException{
    private HttpStatus status;

    public GameException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }
}
