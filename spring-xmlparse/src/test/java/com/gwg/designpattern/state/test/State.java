package com.gwg.designpattern.state.test;
/**
 * 策略模式和状态模式时双胞胎，在出生时才分开
 * @author gaoweigang
 * 首先，让我们创建一个State接口，所有的状态都必须实现这个接口：
 */
public interface State {
	
	//投入2角5分
	public void insertQuarter();
	
	//退还2角5分
	public void ejectQuarter();
	
	//转动曲柄
	public void turnCrank();
	
	//分配
	public void dispense();
	

}
