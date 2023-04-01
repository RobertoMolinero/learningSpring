package sec02endpoints.ch10headerValueTypeRouter;

import org.springframework.messaging.Message;

public interface PrinterGateway {

    void print(Message<?> message);
}
