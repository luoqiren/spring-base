package com.lqr.util;

public class MyClassLoader {

	public static void main(String[] args) {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		System.out.println("current Loader:"+ loader);
		System.out.println("parent Loader:"+ loader.getParent());
		System.out.println("root loader:"+ loader.getParent().getParent());
	}

}
