package sec02endpoints.ch13filter;

import org.springframework.messaging.Message;

public interface PrinterGateway {

    void print(Message<?> message);
}
