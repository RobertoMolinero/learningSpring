package sec04processingEndpoints.ch23asynchronousGateways;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@SpringBootApplication
@Configuration
@ImportResource("/ch23asynchronousGateways.xml")
public class SpringIntegrationDemoApplication implements ApplicationRunner {

    @Autowired
    private EnhancedPrinterGateway gateway;

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
            ListenableFuture<String> future = this.gateway.uppercase(rows[i]);

            future.addCallback(new ListenableFutureCallback<>() {
                @Override
                public void onFailure(Throwable throwable) {
                    System.out.println("Invoking the error callback");
                }

                @Override
                public void onSuccess(String s) {
                    System.out.println("Invoking the success callback");
                    System.out.println(s);
                }
            });
        }
    }
}
