package com.poleszak.usermanagementservice.user.repository;

import com.poleszak.usermanagementservice.user.model.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAppRepository extends JpaRepository<UserApp, Integer> {
    Optional<UserApp> findByEmailAndDeletedDateIsNull(String email);
}
