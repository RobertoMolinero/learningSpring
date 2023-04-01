package sec03transformers.ch19HeaderEnricherAndFilter;

import org.springframework.messaging.Message;

import java.util.Map;

public class PrintService {

    public void print(Message<String> message) {
        System.out.println("BEGIN");

        System.out.println("HEADER");
        for (Map.Entry<String, Object> entry : message.getHeaders().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("PAYLOAD");
        System.out.println(message.getPayload());

        System.out.println("END");
    }
}
