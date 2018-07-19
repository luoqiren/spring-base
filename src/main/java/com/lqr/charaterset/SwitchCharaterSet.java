package com.lqr.charaterset;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class SwitchCharaterSet {

	// java 类里判断字符串是iso-8859-1还是gb2312,utf-8,gbk等,判断编码类型
	// 假设当前的工作环境字符集编码是 UTF8
	public static void main(String[] args) throws UnsupportedEncodingException {

		outputSystemDefaultProperties();
		String str = "查询";
		byte[] strByteArr = str.getBytes();
		String utf8Str = new String(strByteArr, "UTF-8");
		String gbk8Str = new String(strByteArr, "GBK");

		
		System.out.println(getEncoding(str));
		System.out.println(getEncoding(utf8Str));
		System.out.println(getEncoding(gbk8Str));
		
		byte [] utf8ByteArr = str.getBytes("UTF-8");
		byte [] gbkByteArr = str.getBytes("GBK");
		byte [] gb18030ByteArr = str.getBytes("GB18030");
		byte [] gb2312ByteArr = str.getBytes("GB2312");
		
		System.out.println("-------utf8ByteArr------");
		for (int i = 0; i < utf8ByteArr.length; i++) {
			System.out.print(" "+utf8ByteArr[i]);
		}
		System.out.println();
		System.out.println("-------gbkByteArr------");
		for (int i = 0; i < gbkByteArr.length; i++) {
			System.out.print(" "+gbkByteArr[i]);
		}
		System.out.println();
		System.out.println("-------gb18030ByteArr------");
		for (int i = 0; i < gb18030ByteArr.length; i++) {
			System.out.print(" "+gb18030ByteArr[i]);
		}
		System.out.println();
		System.out.println("-------gb2312ByteArr------");
		for (int i = 0; i < gb2312ByteArr.length; i++) {
			System.out.print(" "+gb2312ByteArr[i]);
		}
		
//		System.out.println(java.nio.charset.Charset.forName("GB2312").newEncoder().canEncode(utf8Str));
//		System.out.println(java.nio.charset.Charset.forName("GBK").newEncoder().canEncode(utf8Str));
//		System.out.println(java.nio.charset.Charset.forName("ISO-8859-1").newEncoder().canEncode(utf8Str));
//		System.out.println(java.nio.charset.Charset.forName("UTF-8").newEncoder().canEncode(utf8Str));
	}

	/**
	 * 此方法感觉有一点蠢
	 * @param str
	 * @return
	 */
	public static String getEncoding(String str) {
		//此方法感觉很蠢
		String encode;
		encode = "UTF-16";
		try {
			if (str.equals(new String(str.getBytes(), encode))) {
				return encode;
			}
		} catch (Exception ex) {
		}

		encode = "ASCII";
		try {
			if (str.equals(new String(str.getBytes(), encode))) {
				return "字符串<< " + str + " >>中仅由数字和英文字母组成，无法识别其编码格式";
			}
		} catch (Exception ex) {
		}

		encode = "ISO-8859-1";
		try {
			if (str.equals(new String(str.getBytes(), encode))) {
				return encode;
			}
		} catch (Exception ex) {
		}

		encode = "GB2312";
		try {
			if (str.equals(new String(str.getBytes(), encode))) {
				return encode;
			}
		} catch (Exception ex) {
		}

		encode = "UTF-8";
		try {
			if (str.equals(new String(str.getBytes(), encode))) {
				return encode;
			}
		} catch (Exception ex) {
		}

		/*
		 * ......待完善
		 */

		return "未识别编码格式";
	}

	private static void outputSystemDefaultProperties() {
		// 获取JVM系统默认编码
		System.out.println("系统默认编码：" + System.getProperty("file.encoding")); // 查询结果
		// 系统默认字符编码
		System.out.println("系统默认字符编码：" + Charset.defaultCharset()); // 查询结果
		// 操作系统用户使用的语言
		System.out.println("系统默认语言：" + System.getProperty("user.language")); // 查询结果zh
		
		//比如在JVM启动后在程序中使用properties.setProperty("file.encoding","UTF-8");也不会改变defaultCharset的值~~~
		//如果想指定defaultCharset的值, 则可以通过JVM启动参数(-Dfile.encoding="UTF-8")来显示的指定此JVM的字符集!!!
		
//		System.setProperty("file.encoding", "GBK");
//		System.out.println("系统默认编码：" + System.getProperty("file.encoding")); // 查询结果
//		
	}
}
