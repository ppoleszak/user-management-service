package com.poleszak.security.auth.request;

public record RegisterRequest(
        String firstName,
        String lastName,
        String email,
        String password
) {
}
