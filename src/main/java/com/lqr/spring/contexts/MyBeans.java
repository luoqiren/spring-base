package com.lqr.spring.contexts;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lqr.spring.model.Car;

@Configuration
public class MyBeans {

	@Bean(name="car")
	public Car buildCar(){
		Car car = new Car();
		car.setBrand("蓝鸟");
		car.setSpeed(200);
		return car;
	}
	
}
