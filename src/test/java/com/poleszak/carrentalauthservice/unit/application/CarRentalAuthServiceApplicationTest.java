package com.poleszak.carrentalauthservice.unit.application;

import com.poleszak.carrentalauthservice.CarRentalAuthServiceApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CarRentalAuthServiceApplicationTest {

    @Test
    void contextLoads() {
        CarRentalAuthServiceApplication.main(new String[]{});
    }
}