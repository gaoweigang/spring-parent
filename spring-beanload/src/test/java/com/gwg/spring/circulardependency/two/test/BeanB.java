package com.gwg.spring.circulardependency.two.test;

public class BeanB {
	
	private BeanA beanA;

	public BeanA getBeanA() {
		return beanA;
	}

	public void setBeanA(BeanA beanA) {
		this.beanA = beanA;
	}

}
