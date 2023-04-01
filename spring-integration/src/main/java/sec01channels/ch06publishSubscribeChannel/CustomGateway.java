package sec01channels.ch06publishSubscribeChannel;

import org.springframework.messaging.Message;

public interface CustomGateway {

    void print(Message<String> message);
}
