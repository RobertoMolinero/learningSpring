package sec01channels.ch05channelPriorityQueue;

import org.springframework.messaging.Message;

import java.util.Comparator;

public class CustomMessageComparator implements Comparator<Message<String>> {

    @Override
    public int compare(Message<String> m1, Message<String> m2) {

        String payload = m1.getPayload();
        String payload2 = m2.getPayload();

        boolean isPayloadOfM1Even = Integer.parseInt(payload.substring(payload.length() - 1)) % 2 == 0;
        boolean isPayloadOfM2Even = Integer.parseInt(payload2.substring(payload2.length() - 1)) % 2 == 0;

        if ((isPayloadOfM1Even && isPayloadOfM2Even) || (!isPayloadOfM1Even && !isPayloadOfM2Even)) {
            return 0;
        } else if (isPayloadOfM1Even) {
            return -1;
        } else {
            return 1;
        }
    }
}
