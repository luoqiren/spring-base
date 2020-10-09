package com.lqr.liststudy;

import java.util.ArrayList;
import java.util.List;

/**
* @author 作者 :lqr
* @version 创建时间：2020年10月9日 下午5:02:57
* 类说明
*/
public class ListReserch {
	public static void main(String[] args) {
	    List<String> platformList = new ArrayList<>();
	    platformList.add("AKQQ");
	    platformList.add("AK47");
	    platformList.add("AEIOU");
	    System.out.println(platformList);
	    for (int i = platformList.size() - 1; i >= 0; i--) {
	        String item = platformList.get(i);
	        if (item.equals("AK47")) {
	            platformList.remove(i);
	        }
	    }
	    System.out.println(platformList);
	}
}

