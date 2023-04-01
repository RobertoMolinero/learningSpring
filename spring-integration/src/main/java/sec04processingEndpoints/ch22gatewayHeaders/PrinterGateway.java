package sec04processingEndpoints.ch22gatewayHeaders;

import org.springframework.messaging.Message;

public interface PrinterGateway {

    void print(Message<?> message);
}
