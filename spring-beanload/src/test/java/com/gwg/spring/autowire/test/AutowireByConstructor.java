package com.gwg.spring.autowire.test;

public class AutowireByConstructor {
	
	private Cat cat;
	
	/**
	 * 构造函数自动装配，必须要有构造函数
	 * @return
	 */
	public AutowireByConstructor(Cat cat){
		this.cat = cat;
		System.out.println("构造函数");
	}

	public Cat getCat() {
		return cat;
	}

	public void setCat(Cat cat) {
		this.cat = cat;
	}


}
