package com.gwg.designpattern.observer.test;

/**
 * 建立一个测试程序
 * @author gaoweigang
 *
 */
public class WeatherStation {
	
	public static void main(String[] args) {
		//创建主题
		WeatherData weatherData = new WeatherData();
		
		//当前状况布告板
		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
		//气象统计布告板
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		
		weatherData.setMeasurements(80.0f, 50.5f, 70.0f);
		
		
		
	}

}
