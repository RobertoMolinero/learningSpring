package sec02endpoints.ch11recipientListRouter;

import org.springframework.messaging.Message;

public interface PrinterGateway {

    void print(Message<?> message);
}
