package com.gwg.hello;

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
		
		ApplicationContext bf = new ClassPathXmlApplicationContext("containerextensionTest.xml");
		
		//通过Name方法获取Bean, 可以获取1.id ,2. FactoryBean ("@aa") , 3.alias，会找到对应的id 
		MyTestBean beanByName = (MyTestBean) bf.getBean("myTestBean");
		
	}

}
