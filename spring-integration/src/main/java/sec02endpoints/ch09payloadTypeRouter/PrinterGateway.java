package sec02endpoints.ch09payloadTypeRouter;

import org.springframework.messaging.Message;

public interface PrinterGateway {

    void print(Message<?> message);
}
