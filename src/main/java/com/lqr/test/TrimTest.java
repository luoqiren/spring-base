package com.lqr.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TrimTest {

	public static void main(String[] args) throws ParseException {
//		String str1 = " aaaaa ";
//		String str2 = " aa";		
//		String str3 = "a a ";		
		
//		
//		System.out.println(str1.length());
//		System.out.println(str2.length());
//		System.out.println(str3.length());
//		System.out.println(str1.trim().length());
//		System.out.println(str2.trim().length());
//		System.out.println(str3.trim().length());
//		
		
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy HH:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		String d1 = "19102018 14:40:46";
		
		
		Date d = sdf.parse(d1);
		System.out.println(d);
		
		System.out.println(sdf2.format(d));
	}

}
