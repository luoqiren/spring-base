package com.lqr.liststudy;

import java.util.ArrayList;
import java.util.List;

/**
* @author 作者 :lqr
* @version 创建时间：2020年10月9日 下午5:01:25
* 类说明
*/
public class ListIndexFix {
	public static void main(String[] args) {
		List<String> platformList = new ArrayList<>();
		platformList.add("AKQQ");
		platformList.add("AKQQ");
		platformList.add("AK47");
		platformList.add("AEIOU");
		System.out.println(platformList);

		for (int i = 0; i < platformList.size(); i++) {
			if ("AKQQ".equals(platformList.get(i))) {
				platformList.remove(i);
				i=i-1;
			}
		}
		System.out.println(platformList);
	}
}
