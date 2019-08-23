package com.gwg.spring.java.core.propertydescriptor.test;

public class Cat implements Animal{
	
	private String name;
	
	private int age;
	
	

	public Cat(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
		
	}

	public String getName() {
		return name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge(){
		return age;
	}
}
