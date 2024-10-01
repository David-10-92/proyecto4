package com.user_service_apio.user_service.service;

import com.library_common.library.entities.UserModel;
import com.user_service_apio.user_service.common.dtos.UpdateUser;
import com.user_service_apio.user_service.exceptions.UserException;

public interface UserService {
    UserModel getUser(String id, Long userId) throws UserException;
    void updateUser(String id,UpdateUser updateUser,Long userId);
    void deleteUser(String id,Long userId);
}
