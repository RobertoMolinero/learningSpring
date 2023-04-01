package org.robertoMolinero.spring6di.controller.international;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.robertoMolinero.spring6di.controller.international.MyInternationalController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("EN")
@SpringBootTest
class MyInternationalControllerTest {

    @Autowired
    MyInternationalController myInternationalController;

    @BeforeEach
    void setUp() {
    }

    @Test
    void sayHello() {
        Assertions.assertEquals("Hello, World! - EN", myInternationalController.sayHello());
    }
}