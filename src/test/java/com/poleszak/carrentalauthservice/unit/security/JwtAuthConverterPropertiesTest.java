package com.poleszak.carrentalauthservice.unit.security;

import com.poleszak.carrentalauthservice.security.JwtAuthConverterProperties;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.context.properties.ConfigurationPropertiesBindException;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verifyNoInteractions;

@ExtendWith(MockitoExtension.class)
public class JwtAuthConverterPropertiesTest {

    @Mock
    private ConfigurationPropertiesBindException configurationPropertiesBindException;

    @Test
    void jwtAuthConverterPropertiesTest() {
        JwtAuthConverterProperties properties = new JwtAuthConverterProperties();

        properties.setResourceId("test-resource-id");
        properties.setPrincipalAttribute("test-principal-attribute");

        assertAll("Properties should be set correctly",
                () -> assertEquals("test-resource-id", properties.getResourceId()),
                () -> assertEquals("test-principal-attribute", properties.getPrincipalAttribute())
        );

        verifyNoInteractions(configurationPropertiesBindException);
    }
}
