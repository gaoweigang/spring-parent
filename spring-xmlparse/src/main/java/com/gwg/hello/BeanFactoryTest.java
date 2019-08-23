package com.gwg.hello;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class BeanFactoryTest {
	
	@Test
	public void testSampleLoad(){
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));
		//通过Name获取Bean
		MyTestBean beanByName = (MyTestBean) bf.getBean("myTestBean");
		
		System.out.println(beanByName);
	}

}
