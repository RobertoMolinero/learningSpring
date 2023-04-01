package sec00introduction.ch01serviceActivator;

import org.springframework.messaging.Message;

public class IncorrectPrintService {

    public void print(Message<String> message) {
        throw new RuntimeException("Error!");
    }
}
