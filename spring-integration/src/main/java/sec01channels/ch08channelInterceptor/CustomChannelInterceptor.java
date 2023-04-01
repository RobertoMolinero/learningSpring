package sec01channels.ch08channelInterceptor;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageBuilder;

public class CustomChannelInterceptor implements ChannelInterceptor {

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        Message<String> msg = MessageBuilder.withPayload("PreSend of message [" + message.getPayload().toString() + "]").build();
        return msg;
    }
}
