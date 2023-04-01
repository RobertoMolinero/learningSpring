package org.robertoMolinero.spring6di.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
class ConstructorInjectedControllerTestWithSpring {

    @Autowired
    ConstructorInjectedController constructorInjectedController;

    @Test
    void sayHello() {
        Assertions.assertEquals("Hello, everyone!", constructorInjectedController.sayHello());
    }
}