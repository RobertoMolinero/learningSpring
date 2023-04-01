package org.robertoMolinero.spring6di.service;

import org.springframework.stereotype.Service;

@Service("standardImplementation")
public class GreetingServiceImpl implements GreetingService {

    @Override
    public String sayHello() {
        return "Hello, everyone!";
    }
}
