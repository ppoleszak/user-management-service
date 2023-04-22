package com.poleszak.security.auth.request;

import com.poleszak.security.user.role.Role;

public record RegisterRequest(
        String firstName,
        String lastName,
        String email,
        String password,
        Role role
) {
}
