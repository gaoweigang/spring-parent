package com.gwg.hello;

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
		//通过Name方法获取Bean, 可以获取1.id ,2. FactoryBean ("@aa") , 3.alias，会找到对应的id 
		MyTestBean beanByName = (MyTestBean) bf.getBean("myTestBean");
		
		//通过Class获取Bean
		MyTestBean beanByClass = bf.getBean(MyTestBean.class);
		
		MyTestBeanTwo beanTwo = bf.getBean(MyTestBeanTwo.class);
		
		
		//获取到的是Car
		Car car = (Car) bf.getBean("factoryBean");
		
		//获取到的是FactoryBean
		CarFactoryBean factoryBean = (CarFactoryBean) bf.getBean("&factoryBean");
		
		System.out.println(beanTwo);
		
		//FactoryBean<T>
	}

}
