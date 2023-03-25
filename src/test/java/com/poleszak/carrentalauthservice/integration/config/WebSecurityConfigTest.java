package com.poleszak.carrentalauthservice.integration.config;

import com.poleszak.carrentalauthservice.integration.commons.TestController;
import com.poleszak.carrentalauthservice.config.WebSecurityConfig;
import com.poleszak.carrentalauthservice.security.JwtAuthConverter;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.security.Key;

import static io.jsonwebtoken.SignatureAlgorithm.HS256;
import static java.util.Collections.singletonList;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = TestController.class)
@Import(WebSecurityConfig.class)
public class WebSecurityConfigTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JwtAuthConverter jwtAuthConverter;

    private static final String AUTHORIZATION_HEADER = "Authorization";

    private static final Key secretKey = Keys.secretKeyFor(HS256);
    private static final String validJwtToken = Jwts.builder()
            .setSubject("testUser")
            .claim("roles", singletonList("ROLE_ADMIN"))
            .signWith(secretKey, HS256)
            .compact();

    @Test
    void shouldReturn200ForPublicEndpoint() throws Exception {
        mockMvc.perform(get("/api/v1/car-rental/public")
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @WithMockUser(username = "testUser", authorities = {"ROLE_ADMIN"})
    @Test
    void shouldReturn200ForAuthenticatedRequestToSecuredEndpoint() throws Exception {
        mockMvc.perform(get("/api/v1/car-rental/secure")
                        .header(AUTHORIZATION_HEADER, validJwtToken)
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturn401ForUnauthenticatedRequestToSecuredEndpoint() throws Exception {
        mockMvc.perform(get("/api/v1/car-rental/secure")
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isUnauthorized());
    }
}