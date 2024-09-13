package com.user_service_apio.user_service.service;

import com.library_common.library.entities.UserModel;
import com.user_service_apio.user_service.common.dtos.UpdateUser;
import org.springframework.web.bind.annotation.RequestHeader;

public interface UserService {
    UserModel getUser(String id, Long userId);
    void updateUser(String id,UpdateUser updateUser,Long userId);
    void deleteUser(String id,Long userId);
}
