package com.gwg.spring.aware.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class BeanFactoryTest {
	
	public static void main(String[] args) {
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("awareTest.xml"));
		
		Test test = (Test) beanFactory.getBean("test");
		test.testAware();
		System.out.println(test);

	}

}
