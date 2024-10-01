package com.auth_service_apio.auth_service.service;

import com.auth_service_apio.auth_service.common.dtos.CreateUser;
import com.auth_service_apio.auth_service.common.dtos.TokenResponse;
import com.auth_service_apio.auth_service.common.dtos.LoginUser;
import com.auth_service_apio.auth_service.exceptions.AuthException;

public interface AuthService {

    TokenResponse createUser(CreateUser createUser) throws AuthException;
    TokenResponse loginUser(LoginUser loginUser) throws AuthException;
}
