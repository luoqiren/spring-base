package com.lqr.spring.mybeforeafteradvice.impl;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class GreetBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		String clientName = (String) args[0];
		System.out.println("How are you! Mr. "+clientName);
	}

}
