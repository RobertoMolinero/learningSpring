package org.robertoMolinero.spring6di.service;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Primary
public class GreetingServicePrimary implements GreetingService {

    @Override
    public String sayHello() {
        return "Hello from the primary bean!";
    }
}
