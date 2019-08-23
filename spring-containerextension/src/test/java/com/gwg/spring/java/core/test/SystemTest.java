package com.gwg.spring.java.core.test;

import org.junit.Test;

public class SystemTest {
	
	
	/**
	 * System.getProperties() 与System.getenv() 的区别
	 */
	@Test
	public void testSystem() {
		
		System.getProperties();
		
		System.getenv();
	}
	
	/**
	 * 如何获取泛型
	 */
	public void testStringClassInstanceofClass(){
		 System.out.println(String.class instanceof Class);
		 
		 System.out.println(SystemTest.class instanceof java.lang.Class);
	}
	

}
