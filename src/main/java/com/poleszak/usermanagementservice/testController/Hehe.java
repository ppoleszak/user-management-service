package com.poleszak.usermanagementservice.testController;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/hello")
public class Hehe {

    @GetMapping("/user")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String hello() {
        return "HELLO USER!";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String helloAdmin() {
        return "HELLO ADMIN!";
    }


    @GetMapping
    public String helloNorm() {
        return "HELLO!";
    }
}
