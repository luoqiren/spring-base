package com.lqr.spring.mybeforeafteradvice.impl;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class GreetAfterAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("Enjoy yourself . ");		
	}


}
