package com.gwg.asm.methodparam;

public class TestBean {
	
	private String name;
	
	private int age;
	
	public TestBean(){
		
	}
	
	public TestBean(String name, int age){
		this.name = name;
		this.age = age;
		
	}
	
	public void setName(String name){
		this.name = name;
	}

	public String getName(String name){
		return this.name;
	}
}
