package com.poleszak.carrentalauthservice.unit.model;

import org.junit.jupiter.api.Test;

import static com.poleszak.carrentalauthservice.model.Role.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoleTest {

    @Test
    public void roleValuesTest() {
        assertEquals(ADMIN, valueOf("ADMIN"));
        assertEquals(USER, valueOf("USER"));
    }
}