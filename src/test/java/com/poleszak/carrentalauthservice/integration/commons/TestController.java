package com.poleszak.carrentalauthservice.integration.commons;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/car-rental")
public class TestController {

    @GetMapping("/public")
    public String publicEndpoint() {
        return "Public content";
    }

    @GetMapping("/secure")
    public String securedEndpoint() {
        return "Secured content";
    }
}
