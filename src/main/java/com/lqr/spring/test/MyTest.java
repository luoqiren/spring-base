/**
 * 
 */
package com.lqr.spring.test;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lqr.spring.contexts.MyBeans;
import com.lqr.spring.model.Car;

/**
 * @author lqr
 *
 */
public class MyTest {

	@Ignore
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	@Test
	public void test2() {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext accontext = new AnnotationConfigApplicationContext(MyBeans.class);
		Car car = accontext.getBean("car", Car.class);
		System.out.println(car.getBrand());
		assertNotNull(car);
		assertEquals(car.getBrand(), "蓝鸟");
	}
}
