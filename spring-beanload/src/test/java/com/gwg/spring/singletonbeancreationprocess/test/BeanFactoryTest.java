package com.gwg.spring.singletonbeancreationprocess.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class BeanFactoryTest {
	
	public static void main(String[] args) {
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("singletonBeanCreationProcessTest.xml"));
		
		BeanA beanA = (BeanA) beanFactory.getBean("beanA");
		
		
		System.out.println(beanA);

	}

}
