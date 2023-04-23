package com.poleszak.security.config;

import com.poleszak.jwt.config.JwtPathConfigurer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
@ComponentScan(basePackages = "com.poleszak.jwt")
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

