package com.lqr.spring.aopannotation.setting.impl;

import com.lqr.spring.aopannotation.setting.Waiter;

public class NaiveWaiter implements Waiter {

	@Override
	public void greetTo(String name) {
		System.out.println("Say Hello to:"+name);
	}

	@Override
	public void serverTo(String name) {
		System.out.println("Do Server to:"+name);

	}

}
