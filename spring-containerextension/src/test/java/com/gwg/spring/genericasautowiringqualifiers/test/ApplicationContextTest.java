package com.gwg.spring.genericasautowiringqualifiers.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class ApplicationContextTest {
	
	
	@Test
	public void testAnnotationConfigApplicationContext() {
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfiguration.class);

		StoreService store = (StoreService) applicationContext.getBean("storeService");
		
		System.out.println(store.getS1());
		
	}

}
