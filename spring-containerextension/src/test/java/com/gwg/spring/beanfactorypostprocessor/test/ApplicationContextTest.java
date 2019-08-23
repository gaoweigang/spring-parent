package com.gwg.spring.beanfactorypostprocessor.test;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
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
		
		ConfigurableListableBeanFactory bf = new XmlBeanFactory(new ClassPathResource("beanFactoryPostProcessorTest.xml"));
		
		BeanFactoryPostProcessor bfpp = (BeanFactoryPostProcessor) bf.getBean("bfbb");

		bfpp.postProcessBeanFactory(bf);
		TestBean bean = (TestBean) bf.getBean("testBean");
        
        System.out.println(bean);
	}

}
