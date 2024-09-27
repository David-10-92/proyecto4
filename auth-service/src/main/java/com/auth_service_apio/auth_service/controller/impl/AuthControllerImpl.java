package com.auth_service_apio.auth_service.controller.impl;

import com.auth_service_apio.auth_service.common.dtos.CreateUser;
import com.auth_service_apio.auth_service.common.dtos.LoginUser;
import com.auth_service_apio.auth_service.common.dtos.TokenResponse;
import com.auth_service_apio.auth_service.controller.AuthController;
import com.auth_service_apio.auth_service.exceptions.InvalidLoginException;
import com.auth_service_apio.auth_service.exceptions.UserCreationException;
import com.auth_service_apio.auth_service.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthControllerImpl implements AuthController {

    private final AuthService authService;

    public AuthControllerImpl(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public ResponseEntity<TokenResponse> createUser(CreateUser createUser) throws UserCreationException {
        return ResponseEntity.ok(authService.createUser(createUser));
    }

    @Override
    public ResponseEntity<TokenResponse> loginUser(LoginUser loginUser) throws InvalidLoginException {
        return ResponseEntity.ok(authService.loginUser(loginUser));
    }
}
