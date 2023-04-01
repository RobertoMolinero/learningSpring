package sec02endpoints.ch09payloadTypeRouter;

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
@ImportResource("/ch09payloadTypeRouter.xml")
public class SpringIntegrationDemoApplication implements ApplicationRunner {

    @Autowired
    private PrinterGateway gateway;

    public static void main(String[] args) {
        SpringApplication.run(SpringIntegrationDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments arg) {

        for (int i = 0; i < 10; i++) {
            Message<String> messageString = MessageBuilder
                    .withPayload("Hello World! [" + i + "]")
                    .build();

            Message<Integer> messageInteger = MessageBuilder
                    .withPayload(i)
                    .build();

            this.gateway.print(messageString);
            this.gateway.print(messageInteger);
        }
    }
}
