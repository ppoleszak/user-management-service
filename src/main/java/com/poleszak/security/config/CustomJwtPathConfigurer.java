package com.poleszak.security.config;


import com.poleszak.jwtauthspring.config.JwtPathConfigurer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.stereotype.Component;


@Component
@ComponentScan(basePackages = "com.poleszak.jwtauthspring")
public class CustomJwtPathConfigurer implements JwtPathConfigurer {

    @Override
    public void configure(ServerHttpSecurity http) {
        http
                .authorizeExchange()
                .pathMatchers("/api/v1/auth/**")
                .permitAll()
                .anyExchange()
                .authenticated();
    }
}

