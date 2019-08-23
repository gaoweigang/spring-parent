package com.gwg.designpattern.observer.test;

/**
 * 气象统计布告板
 * @author gaoweigang
 *
 */
public class StatisticsDisplay implements Observer, DisplayElement{
	
	private float temperature;
	private float humidity;
	private float pressure;
	private Subject weatherData;
	
	public StatisticsDisplay(Subject weatherData){
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
		
		System.out.println("气象统计布告板");
	}

	

}
