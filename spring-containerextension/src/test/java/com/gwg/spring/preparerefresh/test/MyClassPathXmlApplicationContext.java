package com.gwg.spring.preparerefresh.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyClassPathXmlApplicationContext extends ClassPathXmlApplicationContext{
	
	public MyClassPathXmlApplicationContext(String... configLocations){
		super(configLocations);
	}
	
	protected void initPropertySources() {
		//添加验证要求
		getEnvironment().setRequiredProperties("VAR");
		
	}

}
