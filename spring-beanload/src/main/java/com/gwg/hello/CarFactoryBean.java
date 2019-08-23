package com.gwg.hello;

import org.springframework.beans.factory.FactoryBean;

public class CarFactoryBean implements FactoryBean<Car>{
	
	private String carInfo;
	
	public CarFactoryBean(String carInfo){
		this.carInfo = carInfo;
	}

	public Car getObject() throws Exception {
		Car car = new Car();
		String[] infos = carInfo.split(",");
		car.setBrand(infos[0]);
		car.setMaxSpeed(Integer.valueOf(infos[1]));
		car.setPrice(Double.valueOf(infos[2]));
		return car;
	}

	public Class<Car> getObjectType() {
		return Car.class;
	}

	public boolean isSingleton() {
		return false;
	}

	public String getCarInfo() {
		return carInfo;
	}

	//接受逗号分隔符设置属性信息
	public void setCarInfo(String carInfo) {
		this.carInfo = carInfo;
	}

}
