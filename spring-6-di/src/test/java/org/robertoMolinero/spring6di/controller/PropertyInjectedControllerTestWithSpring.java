package org.robertoMolinero.spring6di.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PropertyInjectedControllerTestWithSpring {

    @Autowired
    PropertyInjectedController propertyInjectedController;

    @Test
    void sayHello() {
        Assertions.assertEquals("Hello from the primary bean!", propertyInjectedController.sayHello());
    }
}