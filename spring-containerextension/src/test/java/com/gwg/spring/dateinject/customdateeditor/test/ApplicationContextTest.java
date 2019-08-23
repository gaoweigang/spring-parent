package com.gwg.spring.dateinject.customdateeditor.test;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ApplicationContextTest {
	
	/**
	 * 增加属性注册编辑器
	 */
	@Test
	public void testCustomPropertyEditorTest(){
		
		ClassPathXmlApplicationContext bf = new ClassPathXmlApplicationContext("customDateEditorTest.xml");
		TestBean beanOne = (TestBean) bf.getBean("testBean");
		
		System.out.println("name:"+beanOne.getName()+"birthday:"+beanOne.getBirthday());
		
	}
	
}
