package com.gwg.event.test;

/**
 * 该类专门监听正门，监听开门和关门动作
 * @author gaoweigang
 *
 */
public class FrontDoorEventListener implements DoorEventListener{

	public void doorEvent(DoorEvent event) {
		if(event.getDoorState() != null && "open".equals(event.getDoorState())){
			System.out.println("门打开"+FrontDoorEventListener.class.getName());
		}else{
			System.out.println("门关闭"+FrontDoorEventListener.class.getName());
		}
		
	}

}
