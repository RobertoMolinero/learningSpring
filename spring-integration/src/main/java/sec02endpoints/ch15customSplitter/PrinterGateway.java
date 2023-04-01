package sec02endpoints.ch15customSplitter;

import org.springframework.messaging.Message;

public interface PrinterGateway {

    void print(Message<?> message);
}
