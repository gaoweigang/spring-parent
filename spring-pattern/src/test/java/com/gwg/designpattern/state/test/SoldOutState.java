package com.gwg.designpattern.state.test;

public class SoldOutState implements State{
	
	private GumballMachine gumballMachine;
	
	public SoldOutState(GumballMachine gumballMachine){
		this.gumballMachine = gumballMachine;
	}
	

	//这个状态下 不恰当的动作
	public void insertQuarter() {
		System.out.println("糖果已售罄，不能再投币");
		
	}

	//这个状态下 不恰当的动作
	public void ejectQuarter() {
		System.out.println("没有投币 不能退币");
		
	}

	//这个状态下 不恰当的动作
	public void turnCrank() {
		System.out.println("没有投币 不能要求糖果");
	}

	//这个状态下 不恰当的动作
	public void dispense() {
		System.out.println("糖果已售罄 不能发放糖果");
	}

}
