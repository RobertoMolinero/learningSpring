package sec03transformers.ch19HeaderEnricherAndFilter;

import org.springframework.messaging.Message;

public interface PrinterGateway {

    void print(Message<?> message);
}
