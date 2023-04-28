package com.poleszak.security.auth.service;

import com.poleszak.jwtauthspring.service.JwtService;
import com.poleszak.security.auth.controller.request.AuthenticationRequest;
import com.poleszak.security.auth.controller.request.RegisterRequest;
import com.poleszak.security.auth.controller.response.AuthenticationResponse;
import com.poleszak.security.user.model.UserApp;
import com.poleszak.security.user.repository.UserAppRepository;
import com.poleszak.security.user.service.UserAppService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserAppRepository userAppRepository;
    private final UserAppService userAppService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

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
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(registerRequest.email(), registerRequest.password())
        );
        var user = userAppService.loadByUsername(registerRequest.email());
        var jwtToken = jwtService.generateToken(user);

        return new AuthenticationResponse(jwtToken);
    }
}
