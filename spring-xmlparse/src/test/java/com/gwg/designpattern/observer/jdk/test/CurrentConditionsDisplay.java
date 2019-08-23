package com.gwg.designpattern.observer.jdk.test;

import java.util.Observable;
import java.util.Observer;
/**
 * 观察者
 * @author gaoweigang
 *
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement{
    private float temperature;
    private float humidity;
    private float pressure;
    private Observable observable;
	

	public CurrentConditionsDisplay(Observable observable) {
		this.observable = observable;
		this.observable.addObserver(this);
		
	}

	public void update(Observable o, Object arg) {
		if(o instanceof WeatherData){
			WeatherData weatherData = (WeatherData) o;
			this.temperature = weatherData.getTemperature();
			this.humidity = weatherData.getHumidity();
			this.pressure = weatherData.getPressure();
			this.display();
		}
		
	}
	
    public void display() {
		System.out.println("当前状况布告栏*****************");
	}

}
