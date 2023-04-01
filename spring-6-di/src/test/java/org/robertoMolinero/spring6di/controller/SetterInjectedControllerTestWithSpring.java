package org.robertoMolinero.spring6di.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SetterInjectedControllerTestWithSpring {

    @Autowired
    SetterInjectedController setterInjectedController;

    @Test
    void sayHello() {
        Assertions.assertEquals("Hello, everyone!", setterInjectedController.sayHello());
    }
}