package sec02endpoints.ch12customRouter;

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
@ImportResource("/ch12customRouter.xml")
public class SpringIntegrationDemoApplication implements ApplicationRunner {

    @Autowired
    private PrinterGateway gateway;

    public static void main(String[] args) {
        SpringApplication.run(SpringIntegrationDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments arg) {

        for (int i = 0; i < 10; i++) {
            Message<String> stringMessage = MessageBuilder
                    .withPayload("" + i)
                    .build();

            Message<Integer> integerMessage = MessageBuilder
                    .withPayload(i)
                    .build();

            Message<Boolean> booleanMessage = MessageBuilder
                    .withPayload(i%2 == 0)
                    .build();

            this.gateway.print(stringMessage);
            this.gateway.print(integerMessage);
            this.gateway.print(booleanMessage);
        }
    }
}
