package com.gwg.spring.replacedMethod.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class BeanFactoryTest {
	
	public static void main(String[] args) {
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("replacedMethodTest.xml"));
		MyValueCalculator calculator = (MyValueCalculator) beanFactory.getBean("myValueCalculator");
		
		System.out.println(calculator);
		System.out.println("********************"+calculator.computeValue("222"));


	}

}
