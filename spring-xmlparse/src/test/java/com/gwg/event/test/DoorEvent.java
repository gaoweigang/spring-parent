package com.gwg.event.test;

import java.util.EventObject;

/**
 * 定义事件对象，必须继承EventObject? 看Spring源码中 事件对象没有继承EventObject
 *
 */
//public class DoorEvent extends EventObject{
public class DoorEvent{
	
	
	private String doorState = "";//表示门的状态，有“开”和“关”两种

	public DoorEvent(Object source) {
		//super(source);
	}
	
	public DoorEvent(Object source, String doorState) {
		//super(source);
		this.doorState = doorState;
	}

	public String getDoorState() {
		return doorState;
	}

	public void setDoorState(String doorState) {
		this.doorState = doorState;
	}
	
	

}
