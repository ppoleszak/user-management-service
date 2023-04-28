package com.poleszak.security.commons.config;

import com.poleszak.jwtauthspring.config.JwtPathConfigurer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
@ComponentScan(basePackages = "com.poleszak.jwtauthspring")
public class CustomJwtPathConfigurer implements JwtPathConfigurer {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .requestMatchers("/api/v1/auth/**")
                .permitAll()
                .anyRequest()
                .authenticated();
    }
}