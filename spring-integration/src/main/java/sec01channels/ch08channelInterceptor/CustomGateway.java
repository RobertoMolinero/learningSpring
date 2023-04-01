package sec01channels.ch08channelInterceptor;

import org.springframework.messaging.Message;

public interface CustomGateway {

    void print(Message<String> message);
}
