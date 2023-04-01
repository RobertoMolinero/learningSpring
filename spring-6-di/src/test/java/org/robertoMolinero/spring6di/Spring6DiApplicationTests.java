package org.robertoMolinero.spring6di;

import org.junit.jupiter.api.Test;
import org.robertoMolinero.spring6di.controller.MyController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class Spring6DiApplicationTests {

	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	MyController myController;

	@Test
	void testGetControllerFromContext() {
		MyController myController = applicationContext.getBean(MyController.class);
		System.out.println(myController.sayHello());
	}
	@Test
	void testAutowireController() {
		System.out.println(myController.sayHello());
	}

	@Test
	void contextLoads() {
	}
}
