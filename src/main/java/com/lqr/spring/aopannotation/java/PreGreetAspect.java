package com.lqr.spring.aopannotation.java;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;

@Aspect
public class PreGreetAspect {
	
	@Before("execution (* greetTo(..))") //定义切点和增强类型
	public void beforeGreeting(){//增强的横切逻辑
		System.out.println("Before advice, How are you...");
	}
	
/*	@Before("execution (* greetTo(..))") //定义切点和增强类型
	public void beforeGreeting2(String name){//增强的横切逻辑
		System.out.println("Before advice, good men:"+name);
	}*/
	
	@AfterReturning("execution (* greetTo(..))")
	public void afterGreeting(){
		System.out.println("Good luck!");
	}
}
