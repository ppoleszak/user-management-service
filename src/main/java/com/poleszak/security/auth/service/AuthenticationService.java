package com.poleszak.security.auth.service;

import com.poleszak.security.auth.request.AuthenticationRequest;
import com.poleszak.security.auth.request.RegisterRequest;
import com.poleszak.security.auth.response.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    public AuthenticationResponse register(RegisterRequest registerRequest) {
    }

    public AuthenticationResponse verify(AuthenticationRequest registerRequest) {
    }
}
