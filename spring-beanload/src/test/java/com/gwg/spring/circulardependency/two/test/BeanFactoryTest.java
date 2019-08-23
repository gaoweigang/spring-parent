package com.gwg.spring.circulardependency.two.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class BeanFactoryTest {
	
	public static void main(String[] args) {
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("circulardependencyTwoTest.xml"));
		
		BeanB beanOne = (BeanB) beanFactory.getBean("beanB");
		
		System.out.println(beanOne.getBeanA());
		
		BeanB beanTwo = (BeanB) beanFactory.getBean("beanB");
		
		System.out.println(beanTwo.getBeanA());


		

	}

}
