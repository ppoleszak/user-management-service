package com.poleszak.security.user.service;

import com.poleszak.security.user.repository.UserAppRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAppService {

    private final UserAppRepository userAppRepository;

    public UserDetails loadByUsername(String username) {
        return userAppRepository.findByEmailAndDeletedDateIsNull(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found for username: " + username));
    }
}
