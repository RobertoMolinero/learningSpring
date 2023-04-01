package sec03transformers.ch17messageTransformer;

import org.springframework.messaging.Message;

public interface PrinterGateway {

    void print(Message<?> message);
}
