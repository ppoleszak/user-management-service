package com.poleszak.security.testController;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/hello")
public class Hehe {

    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    public String hello() {
        return "HELLO!";
    }
}
