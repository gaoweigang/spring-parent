package com.gwg.designpattern.template.test;

public class Coffee extends CaffeineBeverage{

	@Override
	void brew() {
		System.out.println("brew the coffee");
		
	}

	@Override
	void addCondiments() {
		System.out.println("Adding Sugar and Milk");
		
	}

}
