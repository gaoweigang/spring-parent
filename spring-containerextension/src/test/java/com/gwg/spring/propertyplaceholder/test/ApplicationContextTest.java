package com.gwg.spring.propertyplaceholder.test;

import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ApplicationContextTest {
	
	/**
	 * Spring属性占位符
	 */
	@Test
	public void testPropertyPlaceholderTest(){
		
		ClassPathXmlApplicationContext bf = new ClassPathXmlApplicationContext("propertyPlaceholderTest.xml");

		TestBean beanOne = (TestBean) bf.getBean("testBean");
		
		System.out.println(beanOne.getName());
		
	}

}
