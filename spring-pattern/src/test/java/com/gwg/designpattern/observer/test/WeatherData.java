package com.gwg.designpattern.observer.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class WeatherData implements Subject{
	
	private Set<Observer> observers;
	private float temperature;
	private float humidity;
	private float pressure;

	public WeatherData() {
		observers = new HashSet<Observer>();
	}

	public void registerObserver(Observer o) {
		observers.add(o);
		
	}

	public void removeObserver(Observer o) {
		observers.remove(o);
		
	}

	public void notifyObservers() {
		Iterator<Observer> iter = observers.iterator();
	    while(iter.hasNext()){
	    	Observer o =  iter.next();
	    	//“推”数据给观察者；如果使用“拉”的话，则需以“主题”为参数
	    	o.update(temperature, humidity, pressure);
	    }
		
	}
	
	public void measurementsChanged(){
		notifyObservers();
	}

	public void setMeasurements(float temperature, float humidity, float pressure){
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}

}
