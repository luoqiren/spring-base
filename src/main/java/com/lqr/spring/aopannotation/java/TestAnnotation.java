package com.lqr.spring.aopannotation.java;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

import com.lqr.spring.aopannotation.java.impl.NaiveWaiter;

public class TestAnnotation {

	@Test	
	@Ignore
	public void test() {
		Waiter waiter = new NaiveWaiter();
		waiter.greetTo("Dick");
	}
	
	@Test	
	public void testAspect() {
		Waiter target = new NaiveWaiter();
		AspectJProxyFactory aspectJProxyFactory = new AspectJProxyFactory();
		aspectJProxyFactory.setTarget(target);//设置横切目标对象
		aspectJProxyFactory.addAspect(PreGreetAspect.class);//添加切面类
		
		Waiter proxy = aspectJProxyFactory.getProxy();//生成切面代理对象
		
		proxy.greetTo("Dick");
		
	}
	
	
	
}
