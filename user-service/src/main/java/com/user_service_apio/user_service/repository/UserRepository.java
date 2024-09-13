package com.user_service_apio.user_service.repository;

import com.library_common.library.entities.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
}
