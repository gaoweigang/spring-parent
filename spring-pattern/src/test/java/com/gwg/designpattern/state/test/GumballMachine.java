package com.gwg.designpattern.state.test;

public class GumballMachine {
	
	//糖果售罄状态
	private State soldOutState;
	
	//没投币状态
	private State noQuarterState;
	
	//已投币状态
	private State hasQuarterState;
	
	//出售糖果状态
	private State soldState;
	
	//当前状态
	private State state;
	
	private int count = 0;
	
	public GumballMachine(int numberGumballs){
		this.soldOutState = new SoldOutState(this);
		this.noQuarterState = new NoQuarterState(this);
		this.hasQuarterState = new HasQuarterState(this);
		this.soldState = new SoldState(this);
		this.count = numberGumballs;
		//如果糖果机里面的糖果数量大于0，就将状态设置成没有投币
		if(numberGumballs > 0){
			state = noQuarterState;
		}
	}
	
	//投币
	public void insertQuarter(){
		state.insertQuarter();
	}
	
	//退币
	public void ejectQuarter(){
		state.ejectQuarter();
		
	}
	
	public void turnCrank(){
		//转动曲柄
		state.turnCrank();
		//出糖果
		state.dispense();
	}
	
	/**
	 * 这个方法允许其他的对象(像外面的状态对象)将机器的状态转换到不同的状态
	 * @param state
	 */
	public void setState(State state){
		this.state = state;
	}

	public void releaseBall(){
		System.out.println("A gumball comes rolling out the slot ...");
		if(count != 0){
			count = count - 1;
		}
	}

	public State getSoldOutState() {
		return soldOutState;
	}

	public void setSoldOutState(State soldOutState) {
		this.soldOutState = soldOutState;
	}

	public State getNoQuarterState() {
		return noQuarterState;
	}

	public void setNoQuarterState(State noQuarterState) {
		this.noQuarterState = noQuarterState;
	}

	public State getHasQuarterState() {
		return hasQuarterState;
	}

	public void setHasQuarterState(State hasQuarterState) {
		this.hasQuarterState = hasQuarterState;
	}

	public State getSoldState() {
		return soldState;
	}

	public void setSoldState(State soldState) {
		this.soldState = soldState;
	}

	public int getCount() {
		return count;
	}

	@Override
	public String toString() {
		return "GumballMachine current [state=" + state + "]";
	}

}
