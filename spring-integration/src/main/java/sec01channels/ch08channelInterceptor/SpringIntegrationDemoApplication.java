package sec01channels.ch08channelInterceptor;

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
@ImportResource("/ch08channelInterceptor.xml")
public class SpringIntegrationDemoApplication implements ApplicationRunner {

    @Autowired
    private CustomGateway gateway;

    public static void main(String[] args) {
        SpringApplication.run(SpringIntegrationDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments arg) {

        for (int i = 0; i < 10; i++) {
            Message<String> message = MessageBuilder
                    .withPayload("Hello World! [" + i + "]")
                    .build();

            this.gateway.print(message);
        }
    }
}
