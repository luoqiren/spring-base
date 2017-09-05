package com.lqr.test;

public class Test3 {
	public static void main(String[] args) {
		String str = "a";
		add(str);
		
		System.out.println(str);
		
	}

	private static void add(String str) {
		str = "B" + str;
	}
}
