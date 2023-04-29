package com.poleszak.usermanagementservice.auth.controller.request;

import com.poleszak.jwtauthspring.filter.model.Role;

public record RegisterRequest(
        String firstName,
        String lastName,
        String email,
        String password,
        Role role
) {
}
