package org.robertoMolinero.spring6di.controller.international;

import org.robertoMolinero.spring6di.service.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class MyInternationalController {

    private final GreetingService greetingService;

    public MyInternationalController(@Qualifier("i18nService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello() {
        return greetingService.sayHello();
    }
}


