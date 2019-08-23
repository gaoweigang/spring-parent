package com.gwg.designpattern.decorator.test;

public class StarbuzzCoffe {
	
	public static void main(String[] args) {
		//订一杯Espresso,不需要调料，打印出描述与价钱
		Beverage beverage = new Espresso();
		System.out.println(beverage.getDescription()+" $"+beverage.cost());
		
		//制造出一个HouseBlend对象
		Beverage beverage2 = new HouseBlend();
		beverage2 = new Mocha(beverage2);//用Mocha装饰它
		beverage2 = new Mocha(beverage2);//用第二个Mocha装饰它
		beverage2 = new Whip(beverage2);//用Whip装饰它
		System.out.println(beverage2.getDescription()+" $"+beverage2.cost());
		
	}

}
