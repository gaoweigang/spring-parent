package com.gwg.designpattern.observer.jdk.test;

import java.util.Observable;

/**
 * 主题
 * @author gaoweigang
 *
 */
public class WeatherData extends Observable {
	
	private float temperature;
	
	private float humidity;
	
	private float pressure;
	
	public void measurementsChanged(){
		//在调用notifyObservers()之前，要先调用setChanged()来指示状态已经改变
		setChanged();
		notifyObservers();
	}

	public void setMeasurements(float temperature, float humidity, float pressure){
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}

	public float getTemperature() {
		return temperature;
	}

	public float getHumidity() {
		return humidity;
	}

	public float getPressure() {
		return pressure;
	}
	

}
