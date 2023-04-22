package com.poleszak.security.auth.service;

import com.poleszak.security.auth.request.AuthenticationRequest;
import com.poleszak.security.auth.request.RegisterRequest;
import com.poleszak.security.auth.response.AuthenticationResponse;
import com.poleszak.security.config.service.JwtService;
import com.poleszak.security.user.model.UserApp;
import com.poleszak.security.user.repository.UserAppRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserAppRepository userAppRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthenticationResponse register(RegisterRequest registerRequest) {
        var user = UserApp.builder()
                .firstName(registerRequest.firstName())
                .lastName(registerRequest.lastName())
                .email(registerRequest.email())
                .password(passwordEncoder.encode(registerRequest.password()))
                .role(registerRequest.role())
                .build();
        userAppRepository.save(user);
        var jwtToken = jwtService.generateToken(user);

        return new AuthenticationResponse(jwtToken);
    }

    public AuthenticationResponse verify(AuthenticationRequest registerRequest) {
    }
}
