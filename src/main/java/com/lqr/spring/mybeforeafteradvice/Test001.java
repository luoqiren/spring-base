package com.lqr.spring.mybeforeafteradvice;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test001 {

	@Test
	public void test() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/lqr/spring/mybeforeafteradvice/beans.xml");
		Waiter waiter = (Waiter) context.getBean("waiter");
		waiter.greetTo("fu");
	}

}
