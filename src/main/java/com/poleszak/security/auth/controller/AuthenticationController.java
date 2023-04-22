package com.poleszak.security.auth.controller;

import com.poleszak.security.auth.request.AuthenticationRequest;
import com.poleszak.security.auth.request.RegisterRequest;
import com.poleszak.security.auth.response.AuthenticationResponse;
import com.poleszak.security.auth.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest registerRequest) {
        return ResponseEntity.ok().body(authenticationService.register(registerRequest));
    }

    @PostMapping("/token")
    public ResponseEntity<AuthenticationResponse> verify(@RequestBody AuthenticationRequest registerRequest) {
        return ResponseEntity.ok().body(authenticationService.verify(registerRequest));
    }
}
