package sec00introduction.ch01serviceActivator;

import org.springframework.messaging.Message;

public class PrintService {

    public void print(Message<String> message) {
        System.out.println(message.getPayload());
    }
}
