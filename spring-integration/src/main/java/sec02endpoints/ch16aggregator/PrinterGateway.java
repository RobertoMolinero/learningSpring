package sec02endpoints.ch16aggregator;

import org.springframework.messaging.Message;

public interface PrinterGateway {

    void print(Message<?> message);
}
