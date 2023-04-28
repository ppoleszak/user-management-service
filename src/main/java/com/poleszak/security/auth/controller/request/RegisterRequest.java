package com.poleszak.security.auth.controller.request;

import com.poleszak.security.user.role.Role;

public record RegisterRequest(
        String firstName,
        String lastName,
        String email,
        String password,
        Role role
) {
}
