package com.gwg.java.core.overload;


public class A {
	
	private String name;
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	/**
	 * 这个方法会在类编译后删除，只保留先出现相同方法签名的方法
	 * 对于方法签名相同的方法会在类编译阶段删除后出现的方法
	 * @return
	 */
	/*public Object getName(){
		return this.name;
	}*/
	

}
