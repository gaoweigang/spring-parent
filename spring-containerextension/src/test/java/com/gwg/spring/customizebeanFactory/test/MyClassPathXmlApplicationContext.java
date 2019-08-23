package com.gwg.spring.customizebeanFactory.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyClassPathXmlApplicationContext extends ClassPathXmlApplicationContext{
	
    

    public MyClassPathXmlApplicationContext(String... configLocations)
			throws BeansException {
		super(configLocations);
	}

	/**
     * 自定义BeanFactory
     */
	@Override
	protected void customizeBeanFactory(DefaultListableBeanFactory beanFactory) {
		/*
		 * 这个配置对于单个配置文件无效，在单个配置文件只要存在相同的id或名称的bean,启动就会抛出异常,在这里讨论的是多个配置文件
		 * 此属性的含义：是否允许覆盖同名称的不同定义的BeanDefinition
		 * 默认为true,允许覆盖，后面的配置会覆盖前面的同名的id或name的BeanDefinition
		 * 如果设置成false,不允许覆盖，当存在相同的id或名称的bean时启动会报错
		 */
		super.setAllowBeanDefinitionOverriding(true);
		//此属性的含义：是否允许bean之间存在循环依赖
		super.setAllowCircularReferences(false);
		super.customizeBeanFactory(beanFactory);
	}



}
