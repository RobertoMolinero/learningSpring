package sec02endpoints.ch12customRouter;

import org.springframework.messaging.Message;

public class DefaultPrintService {

    public void print(Message<?> message) {
        System.out.println("Print a default message: " + message.getPayload());
    }
}
