package sec01channels.ch07channelMessagingBridge;

import org.springframework.messaging.Message;

public interface CustomGateway {

    void print(Message<String> message);
}
