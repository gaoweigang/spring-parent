package com.gwg.designpattern.state.test;

public class HasQuarterState implements State{
	
	private GumballMachine gumballMachine;
		
	public HasQuarterState(GumballMachine gumballMachine){
		this.gumballMachine = gumballMachine;
	}

	//这个状态下 不恰当动作
	public void insertQuarter() {
		System.out.println("你已经投入25分钱，不能再投币了");
		
	}

	public void ejectQuarter() {
		System.out.println("退还25分钱，回到没有25分钱状态");
		this.gumballMachine.setState(gumballMachine.getNoQuarterState());
		
	}

	public void turnCrank() {
		System.out.println("转动曲柄....");
		this.gumballMachine.setState(gumballMachine.getSoldState());
		
	}

	//这个状态下  另一个不恰当动作
	public void dispense() {
		System.out.println("请转动曲柄才能获取糖果...");
		
	}

}
