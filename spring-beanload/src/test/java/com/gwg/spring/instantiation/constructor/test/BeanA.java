package com.gwg.spring.instantiation.constructor.test;

import java.beans.ConstructorProperties;

public class BeanA {
	
	private String name;
	
	private int age;
	
	public BeanA(){}
	
	/**
	 * 使用带参的构造函数进行bean的初始化
	 */
	public BeanA(String name){
		System.out.println("使用带参数的构造函数进行初始化...,参数name："+name);
		this.name = name;
	}
	
	@ConstructorProperties(value="age_a")
	public BeanA(int age){
		System.out.println("使用带参数的构造函数进行初始化...,参数age："+age);
		this.age = age;
	}
	
	
	public BeanA(String name , int age){
		System.out.println("使用带参数的构造函数进行初始化...,参数name："+name+",参数age："+age);
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
