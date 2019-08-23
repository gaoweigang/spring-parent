package com.gwg.spring.core.aop.test;

public class TimeAspect {
	
	public void printTime(){
		System.out.println("currentTime :" + System.currentTimeMillis());
	}

}
