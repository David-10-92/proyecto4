package com.auth_service_apio.auth_service.common.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUser {
    @NotNull
    private String username;
    @NotNull
    private String email;
    @NotNull
    private String password;
}
