package com.lqr.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class AutoReadSec {
	
	public static int DEFAULT_ROWS=500;
	
	/**
	 * java读取文件的事 我怎么能根据我想要的行去读取文件呢 
	 * 比如我想读取文件的第500到1000行网上查到的RandomAccessFile是根据字节来的 不太会用
	 * 我可以传3个参数 path startline endline 返回一个List〈String〉
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String s = "C:\\Users\\lqr\\Desktop\\Test.txt";
		File f = new File(s);
		
		if(f.exists()){
			//以只读方式打开文件
			RandomAccessFile randomFile = new RandomAccessFile(f, "r");
			//获取文件大小
			long len = randomFile.length();
			
			System.out.println(len);
			
			
		}
		
		
	}

}
