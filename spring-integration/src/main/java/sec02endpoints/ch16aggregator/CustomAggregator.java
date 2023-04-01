package sec02endpoints.ch16aggregator;

import org.springframework.integration.IntegrationMessageHeaderAccessor;
import org.springframework.integration.aggregator.AbstractAggregatingMessageGroupProcessor;
import org.springframework.integration.store.MessageGroup;
import org.springframework.messaging.Message;

import java.util.Map;

public class CustomAggregator extends AbstractAggregatingMessageGroupProcessor {

    @Override
    protected Object aggregatePayloads(MessageGroup messageGroup, Map<String, Object> map) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Message<?> m : messageGroup.getMessages()) {
            System.out.println(m.getHeaders().get(IntegrationMessageHeaderAccessor.CORRELATION_ID));
            stringBuilder.append(m.getPayload());
        }

        return stringBuilder.toString();
    }
}
