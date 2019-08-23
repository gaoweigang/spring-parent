package com.gwg.designpattern.observer.test;

/**
 * 目前状况布告板
 * @author gaoweigang
 *
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement{
	private float temperature;
	private float humidity;
	private float pressure;
	private Subject weatherData;
	
	public CurrentConditionsDisplay(Subject weatherData){
		this.weatherData = weatherData;
		this.weatherData.registerObserver(this);
		
	}
	
	public void update(float temp, float humidity, float pressure) {
		this.temperature = temp;
		this.humidity = humidity;
		this.pressure = pressure;
		this.display();
		
	}

	public void display() {
		System.out.println("目前状况布告板");
		
	}

	

}
