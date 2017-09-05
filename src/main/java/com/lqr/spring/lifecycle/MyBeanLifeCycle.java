package com.lqr.spring.lifecycle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.lqr.spring.model.Car;

public class MyBeanLifeCycle {

	private static void getCarBean(){
		ApplicationContext accontext = new ClassPathXmlApplicationContext("com/lqr/spring/lifecycle/beans.xml");
		Car car = accontext.getBean("car", Car.class);
		System.out.println(car.getBrand());
	}
	
	private static void lifeCycleInBeanFactory() throws IOException{
		
		/*ApplicationContext bf = new ClassPathXmlApplicationContext("com/lqr/spring/lifecycle/beans.xml");*/
		
		//1 下面两句装载配置文件并启动容器
		Resource  rec = new ClassPathResource("com/lqr/spring/lifecycle/beans.xml");  
		DefaultListableBeanFactory bf = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((DefaultListableBeanFactory)bf);
		reader.loadBeanDefinitions(rec);
		
		System.out.println("rec path:"+rec.getFile().getAbsolutePath());
		
		//2 向容器中注册MyBeanPostProcessor后处理器
		((ConfigurableBeanFactory)bf).addBeanPostProcessor(new MyBeanPostProcessor());
		//3 向容器中注册MyInstantiationAwareBeanPostProcessor后处理器
		((ConfigurableBeanFactory)bf).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());
		
//		((ConfigurableBeanFactory)bf).addBeanPostProcessor((BeanPostProcessor) new MyBeanFactoryPostProcessor());
		//4第一次从容器获取car. 将触发容器实例化该Bean, 这将引发bean生命周期方法的调用
		System.out.println("-----------------------start car-------------------");
		Car car1 = (Car) bf.getBean("car");  
		car1.introduce();
		car1.setColor("红色");
		
		//5 第二次从容器获取car， 直接从缓存池获取
		Car car2 = (Car) bf.getBean("car");
		
		//6查看 car1与car2是否指向同一引用
		System.out.println("car1==car2:"+(car1==car2));
		
		//7关闭容器 
		((DefaultListableBeanFactory)bf).destroySingletons();
		System.out.println("-----------------------destroy car-------------------");
	}
	
	public static void main(String[] args) throws IOException {
		lifeCycleInBeanFactory();
//		getCarBean();
	}

}
