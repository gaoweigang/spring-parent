package com.gwg.designpattern.adapter.classpattern.test;
/**
 * 
 *接口Test1 与 Test2 中定义了完全相同的方法名称test
 */
public class Test implements Test1, Test2{

	public void test(String name) {
		System.out.println("test***********");
		
	}
	
	public static void main(String[] args) {
		Test1 t1 = new Test();
		Test2 t2 = new Test();
		t1.test("");
		t2.test("");
	}

}
