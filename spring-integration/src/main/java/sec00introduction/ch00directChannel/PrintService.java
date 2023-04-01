package sec00introduction.ch00directChannel;

import org.springframework.messaging.Message;

import java.util.Map;

public class PrintService {

    public void print(Message<String> message) {

        System.out.println("Header:");
        for (Map.Entry<String, Object> entry : message.getHeaders().entrySet()) {
            System.out.println("[" + entry.getKey() + ": " + entry.getValue() + "]");
        }

        System.out.println("Payload:");
        System.out.println(message.getPayload());
    }
}
