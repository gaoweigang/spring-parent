package com.gwg.spring.lookupMethod.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class BeanFactoryTest {
	
	public static void main(String[] args) {
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("lookupMethodTest.xml"));
		
		CommandManager commandOne = (CommandManager) beanFactory.getBean("commandManager");
		System.out.println(commandOne.createCommand());
		CommandManager commandTwo = (CommandManager) beanFactory.getBean("commandManager");
		//每次调用createCommand都会返回一个新的 Command实例
		System.out.println(commandTwo.createCommand());
		
		System.out.println(commandTwo);
		
		Command command = (Command) beanFactory.getBean("myCommand");
		System.out.println(command);

	}

}
