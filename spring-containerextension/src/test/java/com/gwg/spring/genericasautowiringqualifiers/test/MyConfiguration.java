package com.gwg.spring.genericasautowiringqualifiers.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {
	
	
	/**
	 * beanId：就是方法的名字storeService
	 */
	@Bean
	public StoreService storeService(){
		return new StoreService();
	}
	
	/**
	 * beanId : 就是方法的名字getStringStore
	 */
	@Bean
	public StringStore getStringStore(){
		return new StringStore();
	}
	
	@Bean
	public IntegerStore getIntegerStore(){
		return new IntegerStore();
	}
	

}
