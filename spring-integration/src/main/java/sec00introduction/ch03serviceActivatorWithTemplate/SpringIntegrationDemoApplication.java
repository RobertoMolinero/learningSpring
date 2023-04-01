package sec00introduction.ch03serviceActivatorWithTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
@Configuration
@ImportResource("/ch03serviceActivatorWithTemplate.xml")
public class SpringIntegrationDemoApplication implements ApplicationRunner {

    @Autowired
    @Qualifier("inputChannel")
    private DirectChannel inputChannel;

    public static void main(String[] args) {
        SpringApplication.run(SpringIntegrationDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments arg) {

        Message<String> message = MessageBuilder
                .withPayload("Hello World!")
                .setHeader("ServiceActivatorWithTemplate Key 1", "Any value 1")
                .setHeader("ServiceActivatorWithTemplate Key 2", "Any value 2")
                .setHeader("ServiceActivatorWithTemplate Key 3", "Any value 3")
                .setHeader("ServiceActivatorWithTemplate Key 4", "Any value 4")
                .setHeader("ServiceActivatorWithTemplate Key 5", "Any value 5")
                .build();

        MessagingTemplate messagingTemplate = new MessagingTemplate();
        Message<?> returnMessage = messagingTemplate.sendAndReceive(inputChannel, message);

        System.out.println("Return Message:");
        System.out.println(returnMessage.getPayload());
    }
}
