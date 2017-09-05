package com.lqr.test;

public class TrimTest {

	public static void main(String[] args) {
		String str1 = " aaaaa ";
		String str2 = " aa";		
		String str3 = "a a ";		
		
		
		System.out.println(str1.length());
		System.out.println(str2.length());
		System.out.println(str3.length());
		System.out.println(str1.trim().length());
		System.out.println(str2.trim().length());
		System.out.println(str3.trim().length());
		
	}

}
