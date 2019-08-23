package com.gwg.designpattern.observer.test;

/**
 * 主题
 * @author gaoweigang
 *
 */
public interface Subject {
	
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	
	/**
	 * 当主题状态改变时，这个方法会被调用，以通知所有观察者
	 */
	public void notifyObservers();

}
