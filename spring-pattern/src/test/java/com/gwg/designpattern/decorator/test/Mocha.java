package com.gwg.designpattern.decorator.test;
/**
 * 调料  Mocha
 * @author gaoweigang
 *
 */
public class Mocha extends CondimentDecorator{
	
	private Beverage beverage;
	
	public Mocha(Beverage beverage){
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Mocha";
	}

	@Override
	public double cost() {
		return .20 + beverage.cost();
	}

}
