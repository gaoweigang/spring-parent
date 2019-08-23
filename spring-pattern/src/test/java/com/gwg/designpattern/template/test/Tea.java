package com.gwg.designpattern.template.test;

/**
 * 茶和咖啡都继承自咖啡因饮料
 *
 */
public class Tea extends CaffeineBeverage{

	@Override
	void brew() {
		System.out.println("Steeping the tea");
		
	}

	@Override
	void addCondiments() {
		System.out.println("Adding Lemon");
		
	}

}
