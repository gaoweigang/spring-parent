package com.gwg.spring.factoryBean.test;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class BeanFactoryTest {
	
	@Test
	public void testSampleLoad(){
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));
		
		//获取到的是Car
		Car car = (Car) bf.getBean("factoryBean");
		
		//获取到的是FactoryBean
		CarFactoryBean factoryBean = (CarFactoryBean) bf.getBean("&factoryBean");
		
		System.out.println(factoryBean);
		
		//FactoryBean<T>
	}

}
