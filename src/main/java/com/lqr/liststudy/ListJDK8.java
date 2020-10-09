package com.lqr.liststudy;

import java.util.ArrayList;
import java.util.List;

/**
* @author 作者 :lqr
* @version 创建时间：2020年10月9日 下午5:05:35
* 类说明
*/
public class ListJDK8 {
	public static void main(String[] args) {
		List<String> platformList = new ArrayList<>();
		platformList.add("AKQQ");
		platformList.add("AKQQ");
		platformList.add("AK47");
		platformList.add("AEIOU");
		System.out.println(platformList);
		//Lambda expression
		platformList.removeIf(splatform -> "AKQQ".equals(splatform));
		System.out.println(platformList);
	}
}
