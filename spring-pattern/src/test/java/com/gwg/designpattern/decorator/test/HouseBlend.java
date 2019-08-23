package com.gwg.designpattern.decorator.test;

public class HouseBlend extends Beverage{
	
	public HouseBlend() {
		this.description = "House Blend Coffee";
	}
	
	@Override
	public double cost() {
		
		return .89;
	}



}
