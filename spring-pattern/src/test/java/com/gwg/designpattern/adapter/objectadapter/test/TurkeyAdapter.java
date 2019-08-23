package com.gwg.designpattern.adapter.objectadapter.test;

public class TurkeyAdapter implements Duck{

	private Turkey turkey;
	
	public TurkeyAdapter(Turkey turkey){
		this.turkey = turkey;
	}
	
	public void quack() {
		turkey.gobble();		
	}

	public void fly() {
		turkey.fly();		
	}

}
