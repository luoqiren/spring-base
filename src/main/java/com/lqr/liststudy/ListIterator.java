package com.lqr.liststudy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author 作者 :lqr
 * @version 创建时间：2020年10月9日 下午4:45:42 类说明
 */
public class ListIterator {
	public static void main(String[] args) {
		List<String> platformList = new ArrayList<>();
		platformList.add("AKQQ");
		platformList.add("AK47");
		platformList.add("AEIOU");
		System.out.println(platformList);
		Iterator<String> iterator = platformList.iterator();
		while (iterator.hasNext()) {
			String platform = iterator.next();
			if (platform.equals("AKQQ")) {
				iterator.remove();
			}
		}
		System.out.println(platformList);
	}
}
