package com.gwg.spring.propertyfile.test;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
/**
 * PropertyPlaceholderConfigurer 这个类比较有意思，实现了spring后置处理器接口BeanFactoryPostProcessor和BeanFactoryAware
 *
 */
public class BeanFactoryTest {
	
	/**
	 * 测试1：
	 */
	@Test
	public void testSpringImportPropertyFileOne(){
		
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("springImportPropertyFileOne.xml"));
		
		PropertyPlaceholderConfigurer beanOne = (PropertyPlaceholderConfigurer) bf.getBean("propertyPlaceholderConfigurer");
		
		
		TestBean testBean = (TestBean) bf.getBean("testBean");
		System.out.println(testBean.getName());
		
	}
	
	/**
	 * 测试2：XmlBeanFactory无法处理占位符，但是ApplicationContext可以处理占位符
	 */
	@Test
	public void testSpringImportPropertyFileTwo(){
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springImportPropertyFileOne.xml");
		
		PropertyPlaceholderConfigurer beanOne = (PropertyPlaceholderConfigurer) applicationContext.getBean("propertyPlaceholderConfigurer");
		
		
		TestBean testBean = (TestBean) applicationContext.getBean("testBean");
		System.out.println(testBean.getName());
		
	}

	
	
}
