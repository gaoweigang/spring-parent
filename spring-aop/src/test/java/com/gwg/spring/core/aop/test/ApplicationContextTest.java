package com.gwg.spring.core.aop.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationContextTest.class);
	
	@Test
	public void testSampleLoad(){
		
		ApplicationContext bf = new ClassPathXmlApplicationContext("aopTest.xml");
		
		TestBean beanOne = (TestBean) bf.getBean("testBean");
		LOGGER.info("TestBean : "+ beanOne);
		beanOne.printHelloWorld();
		
	}

}
