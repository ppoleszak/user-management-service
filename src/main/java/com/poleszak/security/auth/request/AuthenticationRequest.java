package com.poleszak.security.auth.request;

public record AuthenticationRequest(
        String email,
        String password
) {
}
