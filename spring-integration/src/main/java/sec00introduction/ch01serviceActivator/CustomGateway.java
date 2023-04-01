package sec00introduction.ch01serviceActivator;

import org.springframework.messaging.Message;

public interface CustomGateway {

    void print(Message<String> message);
}
