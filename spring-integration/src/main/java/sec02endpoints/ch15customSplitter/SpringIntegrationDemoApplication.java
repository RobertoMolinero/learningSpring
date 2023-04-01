package sec02endpoints.ch15customSplitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
@Configuration
@ImportResource("/ch15customSplitter.xml")
public class SpringIntegrationDemoApplication implements ApplicationRunner {

    @Autowired
    private PrinterGateway gateway;

    public static void main(String[] args) {
        SpringApplication.run(SpringIntegrationDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments arg) {

        Message<String> stringMessage = MessageBuilder
                .withPayload("Ich wollte dir was dedizieren, nein, schenken, was nicht zuviel kostet. Aber was aus Blech ist, rostet, und Messing-Gegenstände oxydieren.")
                .build();
        this.gateway.print(stringMessage);
    }
}
