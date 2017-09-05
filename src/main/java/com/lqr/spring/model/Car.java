package com.lqr.spring.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Car implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean{
	private String brand;
	private String color;
	private long speed;
	
	private BeanFactory beanFactory;
	private String beanName;
	
	
	public Car() {
		System.out.println("调用Car 构造函数");
	}
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		System.out.println("调用brand set函数");
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public long getSpeed() {
		return speed;
	}
	public void setSpeed(long speed) {
		this.speed = speed;
	}
	
	public void introduce(){
		System.out.println("brand is:" + this.brand +" | color is:" + this.color +" | speed is:"+speed);
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("调用DisposableBean.destroy函数");
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("调用InitializingBean.afterPropertiesSet函数");
	}
	@Override
	public void setBeanName(String beanName) {
		System.out.println("调用BeanNameAware.setBeanName函数");
		this.beanName=beanName;
	}
	@Override//BeanFactoryAware 接口方法
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("调用BeanFactoryAware.setBeanFactory函数");
		this.beanFactory = beanFactory;
	}
	
	public BeanFactory getBeanFactory() {
		return beanFactory;
	}

	public String getBeanName() {
		return beanName;
	}

	public void myInit(){
		System.out.println("调用myInit函数， z指定speed=240");
		this.speed=240;
	}
	
	public void myDestroy(){
		System.out.println("调用myDestroy函数");
	}
	
}
