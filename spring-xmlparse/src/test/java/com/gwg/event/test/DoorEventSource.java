package com.gwg.event.test;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 事件源对象，在这里你可以把它想象成一个控制开门关门的遥控器
 * (如果是在swing中，就类似一个button)
 * @author gaoweigang
 *
 */
public class DoorEventSource {
	
	private Set<DoorEventListener> listeners;
	
	/**
	 * 添加事件
	 */
	public void addDoorListener(DoorEventListener listener){
		if(listeners == null){
			listeners = new HashSet<DoorEventListener>();
		}
		listeners.add(listener);
	}
	
	/**
	 * 移除事件
	 */
	public void removeDoorEventListener(DoorEventListener listener){
		if(listeners == null){
			return;
		}
		listeners.remove(listener);
	}
	
	/**
	 * 触发开门事件
	 * @param args
	 */
	public void fireOpenDoorEvent(){
		if(listeners == null){
			return;
		}
		DoorEvent event = new DoorEvent(this, "open");
		notifyListeners(event);
	}
	
	/**
	 * 触发关门事件
	 * @param args
	 */
	public void fireCloseDoorEvent(){
		if(listeners == null){
			return;
		}
		DoorEvent event = new DoorEvent(new Object(), "close");
		notifyListeners(event);
	}
	
	/**
	 * 通知DoorEventListener
	 * @param args
	 */
	public void notifyListeners(DoorEvent event){
		Iterator<DoorEventListener> iter = listeners.iterator();
		while(iter.hasNext()){
			iter.next().doorEvent(event);
		}
		
	}
	
	
	public static void main(String[] args) {
		Set<Object> objects = new HashSet<Object>();
		objects.add(null);
		System.out.println(objects.size());
		
		List<Object> list = new ArrayList<Object>();
		list.remove(1);
		
	}

}
