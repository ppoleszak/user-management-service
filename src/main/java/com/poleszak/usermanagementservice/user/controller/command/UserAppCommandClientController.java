package com.poleszak.usermanagementservice.user.controller.command;

import com.poleszak.usermanagementservice.user.service.UserAppService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user-details")
@RequiredArgsConstructor
public class UserAppCommandClientController {

    private final UserAppService userAppService;

    @GetMapping("/{username}")
    public ResponseEntity<UserDetails> getUserDetails(@PathVariable String username) {
        return ResponseEntity.ok().body(userAppService.loadByUsername(username));
    }
}