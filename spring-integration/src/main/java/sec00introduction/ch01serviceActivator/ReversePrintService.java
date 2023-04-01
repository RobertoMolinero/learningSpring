package sec00introduction.ch01serviceActivator;

import org.springframework.messaging.Message;

public class ReversePrintService {

    public void reverse(Message<String> message) {
        System.out.println(new StringBuilder(message.getPayload()).reverse().toString());
    }
}
