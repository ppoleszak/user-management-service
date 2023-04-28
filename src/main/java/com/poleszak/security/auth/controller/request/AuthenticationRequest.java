package com.poleszak.security.auth.controller.request;

public record AuthenticationRequest(
        String email,
        String password
) {
}
