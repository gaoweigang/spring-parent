package com.gwg.spring.instantiation.constructor.test;

import java.beans.ConstructorProperties;

/**
 * 
 * @author Administrator
 *
 */
public class BeanC {
	
	private String name;
	
	//体重
	private int age;
	
	public BeanC(){}
	
    public BeanC(int age){
    	this.age = age;
    	 System.out.println("age"+age);
	}
	     
	
	public BeanC(String name){
		this.name = name;
		System.out.println("name"+name);
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
