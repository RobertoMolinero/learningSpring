package sec02endpoints.ch15customSplitter;

import org.springframework.messaging.Message;

public class PrintService {

    public void print(Message<String> message) {
        System.out.println("Print a message of type 'String': " + message.getPayload());
    }
}
