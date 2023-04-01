package sec04processingEndpoints.ch23asynchronousGateways;

import org.springframework.messaging.Message;

public interface PrinterGateway {

    void print(Message<?> message);
}
