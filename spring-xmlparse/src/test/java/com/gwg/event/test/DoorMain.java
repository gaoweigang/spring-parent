package com.gwg.event.test;

public class DoorMain {
	
	public static void main(String[] args) {
		DoorEventSource source = new DoorEventSource();
		source.addDoorListener(new FrontDoorEventListener());
		source.addDoorListener(new SideDoorEventListener());
		//开门
		source.fireOpenDoorEvent();
		//关门
		source.fireCloseDoorEvent();
		
		
	}

}
