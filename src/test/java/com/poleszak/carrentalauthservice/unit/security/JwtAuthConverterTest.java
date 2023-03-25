package com.poleszak.carrentalauthservice.unit.security;

import com.poleszak.carrentalauthservice.security.JwtAuthConverter;
import com.poleszak.carrentalauthservice.security.JwtAuthConverterProperties;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.poleszak.carrentalauthservice.model.Role.ADMIN;
import static com.poleszak.carrentalauthservice.model.Role.USER;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JwtAuthConverterTest {

    @Mock
    private JwtAuthConverterProperties properties;

    @InjectMocks
    private JwtAuthConverter converter;

    @Test
    void convert() {
        // given
        Jwt jwt = mock(Jwt.class);
        Map<String, Object> resourceAccess = new HashMap<>();
        Map<String, Object> resource = new HashMap<>();
        List<String> roles = List.of(ADMIN.name(), USER.name());

        resource.put("roles", roles);
        resourceAccess.put("resource-id", resource);

        when(properties.getResourceId()).thenReturn("resource-id");
        when(properties.getPrincipalAttribute()).thenReturn("sub");
        when(jwt.getClaim("resource_access")).thenReturn(resourceAccess);
        when(jwt.getClaim("sub")).thenReturn("sub-value");

        // when
        AbstractAuthenticationToken result = converter.convert(jwt);

        // then
        assertAll("result",
                () -> assertNotNull(result),
                () -> assertTrue(result != null && result.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .anyMatch("ROLE_ADMIN"::equals)),
                () -> assertTrue(result != null && result.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .anyMatch("ROLE_USER"::equals))
        );
    }
}
