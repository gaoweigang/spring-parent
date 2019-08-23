package com.gwg.designpattern.adapter.objectadapter.test;

public class DuckTestDrive {
	public static void main(String[] args) {
		
		//先创建一只鸭子
		MallardDuck duck = new MallardDuck();
		
		//火鸡
		WildTurkey turkey = new WildTurkey();
		
		//然后将火鸡包装进一个火鸡适配器中，使它看起来像一只鸭子
		Duck turkeyAdapter = new TurkeyAdapter(turkey);
		
		System.out.println("The Turkey  says ....");
		turkeyAdapter.quack();
		turkeyAdapter.fly();
		
	}

}
