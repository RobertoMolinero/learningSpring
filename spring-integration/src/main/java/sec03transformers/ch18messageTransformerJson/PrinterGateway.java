package sec03transformers.ch18messageTransformerJson;

import org.springframework.messaging.Message;

public interface PrinterGateway {

    void print(Message<?> message);
}
