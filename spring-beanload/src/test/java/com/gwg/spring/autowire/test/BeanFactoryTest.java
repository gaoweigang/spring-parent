package com.gwg.spring.autowire.test;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
/**
 * 
 */
public class BeanFactoryTest {
	
	@Test
	public void testAutowireByConstructor() {
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("autowireTest.xml"));
		
		AutowireByConstructor beanOne = (AutowireByConstructor) beanFactory.getBean("autowireByConstructor");
		System.out.println(beanOne);
	}
	

}
