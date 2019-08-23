package com.gwg.spring.instantiation.constructor.test;

import java.beans.ConstructorProperties;


public class BeanB {
	
	private String name;
	
	//体重
	private int weight;
	
	public BeanB(){}
	
	/**
	 * 使用带参的构造函数进行bean的初始化
	 */
	public BeanB(String name){
		System.out.println("使用带参数的构造函数进行初始化...,参数name："+name);
		this.name = name;
	}
	
	@ConstructorProperties(value="")
	public BeanB(int weight){
		System.out.println("使用带参数的构造函数进行初始化...,参数age："+weight);
		this.weight = weight;
	}
	
	
	public BeanB(String name , int weight){
		System.out.println("使用带参数的构造函数进行初始化...,参数name："+name+",参数age："+weight);
		this.name = name;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}
