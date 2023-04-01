package sec02endpoints.ch11recipientListRouter;

import org.springframework.messaging.Message;

public class DefaultPrintService {

    public void print(Message<String> message) {
        System.out.println("Print a default message: " + message.getPayload());
    }
}
