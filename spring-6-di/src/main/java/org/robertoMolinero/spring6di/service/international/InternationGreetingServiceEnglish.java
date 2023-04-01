package org.robertoMolinero.spring6di.service.international;

import org.robertoMolinero.spring6di.service.GreetingService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"EN", "default"})
@Service("i18nService")
public class InternationGreetingServiceEnglish implements GreetingService {

    @Override
    public String sayHello() {
        return "Hello, World! - EN";
    }
}
