package com.gwg.designpattern.adapter.objectadapter.test;
/**
 * 这是火鸡的一个具体实现。就和鸭子一样，只是打印出火鸡的动作说明
 * @author gaoweigang
 *
 */
public class WildTurkey implements Turkey{

	public void gobble() {
		System.out.println("Gobble gobble");
		
	}

	public void fly() {
		System.out.println("I am flying a short distance");
	}

}
