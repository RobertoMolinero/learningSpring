package sec02endpoints.ch12customRouter;

import org.springframework.messaging.Message;

public interface PrinterGateway {

    void print(Message<?> message);
}
