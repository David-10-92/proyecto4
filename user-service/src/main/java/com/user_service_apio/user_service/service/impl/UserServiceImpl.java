package com.user_service_apio.user_service.service.impl;

import com.library_common.library.entities.UserModel;
import com.user_service_apio.user_service.common.dtos.UpdateUser;
import com.user_service_apio.user_service.repository.UserRepository;
import com.user_service_apio.user_service.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserModel getUser(String id,Long userId) {
        return Optional.of(userId)
                .flatMap(userRepository::findById)
                .orElseThrow(()-> new RuntimeException("User not found"));
    }

    @Override
    public void updateUser(String id,UpdateUser updateUser, Long userId) {
        Optional.of(userId)
                .map(this::getUserById)
                .map(existUser -> updateFields(existUser,updateUser))
                .map(userRepository::save);
    }

    private UserModel updateFields(UserModel existUser, UpdateUser updateUser) {
        existUser.setUsername(updateUser.getUsername());
        existUser.setEmail(updateUser.getEmail());
        return existUser;
    }

    private UserModel getUserById(Long aLong) {
        return userRepository.findById(aLong)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public void deleteUser(String id,Long userId) {
        Optional.of(userId)
                .map(this::getUserById)
                .ifPresent(userRepository::delete);
    }
}
