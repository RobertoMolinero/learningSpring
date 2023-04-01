package org.robertoMolinero.spring6di;

import org.robertoMolinero.spring6di.controller.MyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Spring6DiApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(Spring6DiApplication.class, args);

		MyController myController = applicationContext.getBean(MyController.class);

		System.out.println("I'm in the main method.");
		System.out.println(myController.sayHello());
	}
}
