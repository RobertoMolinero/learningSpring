package sec02endpoints.ch14customFilter;

import org.springframework.messaging.Message;

public class PrintService {

    public void print(Message<String> message) {
        System.out.println("Print a message of type 'String': " + message.getPayload());
    }
}
