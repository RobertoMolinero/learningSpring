package sec02endpoints.ch10headerValueTypeRouter;

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
@ImportResource("/ch10headerValueTypeRouter.xml")
public class SpringIntegrationDemoApplication implements ApplicationRunner {

    @Autowired
    private PrinterGateway gateway;

    public static void main(String[] args) {
        SpringApplication.run(SpringIntegrationDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments arg) {

        for (int i = 0; i < 10; i++) {
            Message<String> messageA = MessageBuilder
                    .withPayload("Hello World! [Type A]")
                    .setHeader("routeHeader", "A")
                    .build();

            Message<String> messageB = MessageBuilder
                    .withPayload("Hello World! [Type B]")
                    .setHeader("routeHeader", "B")
                    .build();

            Message<String> messageDefault = MessageBuilder
                    .withPayload("Hello World! [Default]")
                    .build();

            this.gateway.print(messageA);
            this.gateway.print(messageB);
            this.gateway.print(messageDefault);
        }
    }
}
