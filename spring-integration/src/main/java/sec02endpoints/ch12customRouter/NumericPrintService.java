package sec02endpoints.ch12customRouter;

import org.springframework.messaging.Message;

public class NumericPrintService {

    public void print(Message<Integer> message) {
        System.out.println("Print a message of type 'Integer': " + message.getPayload());
    }
}
