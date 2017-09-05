package com.lqr.spring.aopannotation.setting;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class PreGreetAspect {
	
	@Before("execution (* greetTo(..))") //定义切点和增强类型
	public void beforeGreeting(){//增强的横切逻辑
		System.out.println("Before advice, How are you...");
	}
	
}
