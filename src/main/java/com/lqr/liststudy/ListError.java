package com.lqr.liststudy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 作者 :lqr
 * @version 创建时间：2020年10月9日 下午4:16:54 类说明
 */
public class ListError {
	public static void main(String[] args) {
		List<String> platformList = new ArrayList<>();
		platformList.add("AKQQ");
		platformList.add("AK47");
		platformList.add("AEIOU");
		System.out.println(platformList);

		for (String platform : platformList) {
			if ("AKQQ".equals(platform)) {
				platformList.remove(platform);
			}
		}

		System.out.println(platformList);
	}
}
