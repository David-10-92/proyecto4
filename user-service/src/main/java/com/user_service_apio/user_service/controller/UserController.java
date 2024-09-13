package com.user_service_apio.user_service.controller;

import com.library_common.library.entities.UserModel;
import com.user_service_apio.user_service.common.constants.ApiPathConstants;
import com.user_service_apio.user_service.common.dtos.UpdateUser;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(ApiPathConstants.V1_ROUTER + ApiPathConstants.USER_ROUTER)
@SecurityRequirement(name = "Bearer Authentication")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public interface UserController {

    @GetMapping(value = "{userId}")
    ResponseEntity<UserModel> getUser(@RequestHeader("userIdRequest") String authId,@PathVariable Long userId);

    @PutMapping(value = "{userId}")
    ResponseEntity<Void> updateUser(@RequestHeader("userIdRequest") String authId,@Valid @RequestBody UpdateUser updateUser, @PathVariable Long userId);

    @DeleteMapping(value = "{userId}")
    ResponseEntity<Void> deleteUser(@RequestHeader("userIdRequest") String authId,@PathVariable Long userId);
}
