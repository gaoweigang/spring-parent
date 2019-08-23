package com.gwg.designpattern.state.test;

public class NoQuarterState implements State{
	
    private GumballMachine gumballMachine;
		
	public NoQuarterState(GumballMachine gumballMachine){
		this.gumballMachine = gumballMachine;
	}

	public void insertQuarter() {
		System.out.println("you inserted a quarter");
		this.gumballMachine.setState(gumballMachine.getHasQuarterState());
	}

	//如果没给钱 就不能要求退款
	public void ejectQuarter() {
		System.out.println("你还没有投入25分钱");
	}

	//如果没给钱，就不能要求糖果
	public void turnCrank() {
		System.out.println("你转动了曲柄，但是还没有投入25分钱");
		
	}

	//如果没得到钱 外面就不能发放糖果
	public void dispense() {
		System.out.println("你要先付25分钱");
		
	}

}
