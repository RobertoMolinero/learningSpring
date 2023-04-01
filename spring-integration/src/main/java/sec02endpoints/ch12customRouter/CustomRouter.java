package sec02endpoints.ch12customRouter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.router.AbstractMessageRouter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import java.util.ArrayList;
import java.util.Collection;

public class CustomRouter extends AbstractMessageRouter {

    @Autowired
    @Qualifier("integerChannel")
    private MessageChannel integerChannel;

    @Autowired
    @Qualifier("stringChannel")
    private MessageChannel stringChannel;

    @Autowired
    @Qualifier("defaultChannel")
    private MessageChannel defaultChannel;

    @Override
    protected Collection<MessageChannel> determineTargetChannels(Message<?> message) {
        Collection<MessageChannel> targetChannels = new ArrayList<MessageChannel>();

        if(message.getPayload().getClass().equals(Integer.class)) {
            targetChannels.add(integerChannel);
        } else if(message.getPayload().getClass().equals(String.class)) {
            targetChannels.add(stringChannel);
        } else {
            targetChannels.add(defaultChannel);
        }

        return targetChannels;
    }
}
