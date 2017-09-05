package com.lqr.spring.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.lqr.spring.model.Car;

public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if("car".equals(beanName)){
			Car car = (Car) bean;
			if(car.getSpeed() >= 200){
				System.out.println("调用BeanPostProcessor.postProcess  AfterInitialization(), Speed 大于200, 重置为200");
				car.setSpeed(200);
			}
		}
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if("car".equals(beanName)){
			Car car = (Car) bean;
			if(car.getColor()==null){
				System.out.println("调用BeanPostProcessor.postProcess  BeforeInitialization(), color 为空, 设置为黑色");
				car.setColor("黑色");
			}
		}
		return bean;
	}

}
