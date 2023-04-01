package sec03transformers.ch18messageTransformerJson;

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
@ImportResource("/ch18messageTransformerJson.xml")
public class SpringIntegrationDemoApplication implements ApplicationRunner {

    @Autowired
    private PrinterGateway gateway;

    public static void main(String[] args) {
        SpringApplication.run(SpringIntegrationDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments arg) {

        Person[] rows = {
                new Person("Pat", "Hanrahan"),
                new Person("Edwin", "Catmull"),
                new Person("Geoffrey", "Hinton"),
                new Person("Yann", "LeCun"),
                new Person("Yoshua", "Bengio"),
                new Person("David", "Patterson"),
                new Person("Tim", "Berners-Lee")
        };

        for (int i = 0; i < rows.length; i++) {
            Message<?> msg = MessageBuilder
                    .withPayload(rows[i])
                    .build();

            this.gateway.print(msg);
        }
    }
}
