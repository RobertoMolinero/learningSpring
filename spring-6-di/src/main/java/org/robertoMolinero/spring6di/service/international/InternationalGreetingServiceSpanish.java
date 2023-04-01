package org.robertoMolinero.spring6di.service.international;

import org.robertoMolinero.spring6di.service.GreetingService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("ES")
@Service("i18nService")
public class InternationalGreetingServiceSpanish implements GreetingService {

    @Override
    public String sayHello() {
        return "Hola Munda! - ES";
    }
}
