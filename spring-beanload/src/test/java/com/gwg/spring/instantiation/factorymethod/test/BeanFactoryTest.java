package com.gwg.spring.instantiation.factorymethod.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class BeanFactoryTest {
	
	public static void main(String[] args) {
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("factoryMethodTest.xml"));
		
		ClientService clientService = (ClientService) beanFactory.getBean("clientService");
		
		System.out.println(clientService);
		
		ClientService clientServiceTwo = (ClientService) beanFactory.getBean("clientService");

		System.out.println(clientServiceTwo);
		System.out.println(clientService == clientServiceTwo);


	}

}
