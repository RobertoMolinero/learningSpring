package sec04processingEndpoints.ch21gateway;

import org.springframework.messaging.Message;

import java.util.Map;

public class PrintService {

    public void print(Message<?> message) {
        System.out.println(message.getPayload());

        for (Map.Entry<String, Object> entry : message.getHeaders().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
