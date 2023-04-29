package com.poleszak.usermanagementservice.auth.controller.request;

public record AuthenticationRequest(
        String email,
        String password
) {
}
