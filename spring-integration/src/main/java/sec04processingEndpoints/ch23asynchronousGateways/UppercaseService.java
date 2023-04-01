package sec04processingEndpoints.ch23asynchronousGateways;

import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class UppercaseService {

    public String execute(Person p) {
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return (p.getFirstName() + " " + p.getLastName()).toUpperCase(Locale.ROOT);
    }
}
