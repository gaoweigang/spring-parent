package com.gwg.spring.customizebeanFactory.test;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class ApplicationContextTest {
	
	/**
	 * 这个测试需要多个配置文件
	 */
	@Test
	public void testSampleLoad(){
		
		ApplicationContext applicationContext = new MyClassPathXmlApplicationContext("customizeBeanFactoryTest.xml","customizeBeanFactoryTwoConfigTest.xml");
		
        BeanB bean = (BeanB) applicationContext.getBean("bean");
        
        System.out.println(bean);
	}

}
