package sec00introduction.ch00directChannel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
@Configuration
@ImportResource("/ch00directChannel.xml")
public class SpringIntegrationDemoApplication implements ApplicationRunner {

    @Autowired
    private DirectChannel channel;

    public static void main(String[] args) {
        SpringApplication.run(sec00introduction.ch00directChannel.SpringIntegrationDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments arg) {

        channel.subscribe(message -> new PrintService().print((Message<String>) message));

        Message<String> message = MessageBuilder
                .withPayload("Hello World!")
                .setHeader("User defined key A", "Any value 1")
                .setHeader("User defined key B", "Any value 2")
                .setHeader("User defined key C", "Any value 3")
                .setHeader("User defined key D", "Any value 4")
                .setHeader("User defined key E", "Any value 5")
                .build();
        channel.send(message);
    }
}
