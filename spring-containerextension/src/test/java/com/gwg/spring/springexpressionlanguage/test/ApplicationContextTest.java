package com.gwg.spring.springexpressionlanguage.test;

import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ApplicationContextTest {
	
	/**
	 * Spring Expression Language
	 */
	@Test
	public void testSpringExpressionLanguageTest(){
		
		ClassPathXmlApplicationContext bf = new ClassPathXmlApplicationContext("springExpressionLanguageTest.xml");

		Cat cat = (Cat) bf.getBean("cat");

		System.out.println(cat);
		
		TestBean beanOne = (TestBean) bf.getBean("testBean");
		
		System.out.println(beanOne.getCat());
		
	}

}
