package sec01channels.ch04channelQueue;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Map;

public class PrintService {

    public Message<?> print(Message<String> message) {

        System.out.println("Header:");
        for (Map.Entry<String, Object> entry : message.getHeaders().entrySet()) {
            System.out.println("[" + entry.getKey() + ": " + entry.getValue() + "]");
        }

        System.out.println("Payload:");
        System.out.println(message.getPayload());

        int messageNumber = (int) message.getHeaders().get("messageNumber");
        return MessageBuilder.withPayload("Everything worked out wonderfully for messageNumber " + messageNumber).build();
    }
}
