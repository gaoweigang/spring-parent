package com.gwg.designpattern.decorator.test;
/**
 * 调料  Mocha
 * @author gaoweigang
 *
 */
public class Whip extends CondimentDecorator{
	
	private Beverage beverage;
	
	public Whip(Beverage beverage){
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Whip";
	}

	@Override
	public double cost() {
		return .23 + beverage.cost();
	}

}
