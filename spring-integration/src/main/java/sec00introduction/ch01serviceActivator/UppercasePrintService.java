package sec00introduction.ch01serviceActivator;

import org.springframework.messaging.Message;

import java.util.Locale;

public class UppercasePrintService {

    public void print(Message<String> message) {
        System.out.println(message.getPayload().toUpperCase(Locale.ROOT));
    }
}
