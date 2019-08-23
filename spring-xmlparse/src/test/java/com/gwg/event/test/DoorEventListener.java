package com.gwg.event.test;

import java.util.EventListener;

/**
 * 定义新的事件监听接口，该接口继承自EventListener;该接口包含对DoorEvent事件的处理程序
 * 定义监听接口，负责监听DoorEvent
 * @author gaoweigang
 *
 */
public interface DoorEventListener extends EventListener{
	public void doorEvent(DoorEvent event);
}
