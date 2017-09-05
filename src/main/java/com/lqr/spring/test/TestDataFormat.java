package com.lqr.spring.test;

import java.text.MessageFormat;
import java.util.Calendar;

public class TestDataFormat {

	public static void main(String[] args) {
		String pattern1 = "{0}, 你好！ 在{1} 的时候进行登录了{2}系统， 欢迎！！";
		
		Object [] params = {"Jack" , Calendar.getInstance().getTime(), "APISF"};
		
		
		MessageFormat mf = new MessageFormat(pattern1);
		String afterPattern = mf.format(params);
		System.out.println(afterPattern);
		
	}

}
