package com.gwg.spring.lookupMethod.test;

public class AsyncCommand extends Command {

	public Object execute() {
		System.out.println(this.state);
		return this.state;
	}

	
}
