package sec04processingEndpoints.ch20serviceActivatorAdvanced;

import org.springframework.messaging.Message;

public interface PrinterGateway {

    void print(Message<?> message);
}
