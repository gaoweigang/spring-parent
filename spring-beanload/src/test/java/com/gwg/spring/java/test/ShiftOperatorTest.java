package com.gwg.spring.java.test;

import org.junit.Test;

public class ShiftOperatorTest {
	
	@Test
	public void testShiftOperator(){
		/**
		 * 11 0000 0000 0000 0000
		 * 00 0000 0000 0010 1101
		 * 进行或运算之后的值：
		 * 11 0000 0000 0010 1101
		 * 结论：或运算可以进行java中的加法操作
		 */
		System.out.println(3 << 16); 
		System.out.println(3 << 16 | 45); 
		System.out.println(Integer.toBinaryString(45));
	}

	@Test
	public void testClass(){
		Class clazz = ShiftOperatorTest.class;
		String classFileName = clazz.getName();
		System.out.println(classFileName);
		//classFileName.lastIndexOf()
		//clazz.getResourceAsStream()
	}

}
