package com.user_service_apio.user_service.controller.impl;

import com.library_common.library.entities.UserModel;
import com.user_service_apio.user_service.common.dtos.UpdateUser;
import com.user_service_apio.user_service.controller.UserController;
import com.user_service_apio.user_service.exceptions.UserNotFoundException;
import com.user_service_apio.user_service.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControllerImpl implements UserController {

    private final UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<UserModel> getUser(String authId,Long userId) throws UserNotFoundException {
        return ResponseEntity.ok(userService.getUser(authId, userId));
    }

    @Override
    public ResponseEntity<Void> updateUser(String authId,UpdateUser updateUser, Long userId) {
        userService.updateUser(authId,updateUser,userId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> deleteUser(String authId,Long userId) {
        userService.deleteUser(authId, userId);
        return ResponseEntity.noContent().build();
    }
}
