package com.gwg.spring.configfile.filenameplaceholer.test;

import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ApplicationContextTest {
	
	/**
	 * Spring配置文件名使用占位符，需要在系统环境变量中设置multiple.config.file = fileNamePlaceholder
	 * 或者虚拟机启动参数(JVM arguments):-Dmultiple.config.file=fileNamePlaceholder
	 */
	@Test
	public void testFileNamePlaceholder(){
		
		ClassPathXmlApplicationContext bf = new ClassPathXmlApplicationContext("${multiple.config.file}OneTest.xml", "${multiple.config.file}TwoTest.xml");

		TestOneBean beanOne = (TestOneBean) bf.getBean("testOneBean");
		
		System.out.println(beanOne);
		
	}

}
