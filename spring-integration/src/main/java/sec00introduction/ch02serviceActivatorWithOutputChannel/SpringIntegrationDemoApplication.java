package sec00introduction.ch02serviceActivatorWithOutputChannel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
@ImportResource("/ch02serviceActivatorWithOutputChannel.xml")
public class SpringIntegrationDemoApplication implements ApplicationRunner {

    @Autowired
    @Qualifier("inputChannel")
    private DirectChannel inputChannel;

    @Autowired
    @Qualifier("outputChannel")
    private DirectChannel outputChannel;

    public static void main(String[] args) {
        SpringApplication.run(SpringIntegrationDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments arg) {

        outputChannel.subscribe(message -> System.out.println("Output:\n" + message.getPayload()));

        Message<String> message = MessageBuilder
                .withPayload("Hello World!")
                .setHeader("Key 1", "Any value 1")
                .setHeader("Key 2", "Any value 2")
                .setHeader("Key 3", "Any value 3")
                .setHeader("Key 4", "Any value 4")
                .setHeader("Key 5", "Any value 5")
                .build();

        inputChannel.send(message);
    }
}
