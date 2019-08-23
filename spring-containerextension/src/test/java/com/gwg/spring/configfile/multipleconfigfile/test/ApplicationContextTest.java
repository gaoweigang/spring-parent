package com.gwg.spring.configfile.multipleconfigfile.test;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class ApplicationContextTest {
	
	@Test
	public void testSampleLoad(){
		
		ApplicationContext bf = new ClassPathXmlApplicationContext("configFileOneTest.xml","configFileTwoTest.xml");
		
		TestOneBean beanOne = (TestOneBean) bf.getBean("testOneBean");
		
		System.out.println(beanOne);
		
	}

}
