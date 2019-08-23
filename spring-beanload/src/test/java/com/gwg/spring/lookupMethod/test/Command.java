package com.gwg.spring.lookupMethod.test;

public abstract class Command {
	
	public Object state;
	
	public abstract Object execute();
	
	public Object getState() {
		return state;
	}

	public void setState(Object state) {
		this.state = state;
	}
	

}
