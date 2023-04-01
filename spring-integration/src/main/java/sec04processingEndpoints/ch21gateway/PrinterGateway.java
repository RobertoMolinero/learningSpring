package sec04processingEndpoints.ch21gateway;

import org.springframework.messaging.Message;

public interface PrinterGateway {

    void print(Message<?> message);
}
