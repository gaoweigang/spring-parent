package com.gwg.designpattern.state.test;

/**
 * 设计中的每个状态都封装成一个类，每个都实现State接口
 * @author gaoweigang
 *
 */
public class SoldState implements State{
	
    private GumballMachine gumballMachine;
	
	public SoldState(GumballMachine gumballMachine){
		this.gumballMachine = gumballMachine;
	}
	

	//这个状态下 不恰当的动作
	public void insertQuarter() {
		
		System.out.println("请等待，正在给你发放糖果...");
	}

	//这个状态下 不恰当的动作
	public void ejectQuarter() {
		System.out.println("对不起，你已经转动了曲柄，不能退币");
	}

	//这个状态不恰当的动作
	public void turnCrank() {
		System.out.println("再次转动曲柄不会多得到一个糖果");
	}

	public void dispense() {
		if(gumballMachine.getCount() > 0){
			this.gumballMachine.releaseBall();
			this.gumballMachine.setNoQuarterState(gumballMachine.getNoQuarterState());
			
		}else if(gumballMachine.getCount() == 0){
			System.out.println("糖果已售罄");
			this.gumballMachine.setSoldOutState(gumballMachine.getSoldOutState());
		}
	}

}
