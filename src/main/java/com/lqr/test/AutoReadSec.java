package com.lqr.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class AutoReadSec {
	
	public static int DEFAULT_ROWS=500;
	
	/**
	 * java��ȡ�ļ����� ����ô�ܸ�������Ҫ����ȥ��ȡ�ļ��� 
	 * ���������ȡ�ļ��ĵ�500��1000�����ϲ鵽��RandomAccessFile�Ǹ����ֽ����� ��̫����
	 * �ҿ��Դ�3������ path startline endline ����һ��List��String��
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String s = "C:\\Users\\lqr\\Desktop\\Test.txt";
		File f = new File(s);
		
		if(f.exists()){
			//��ֻ����ʽ���ļ�
			RandomAccessFile randomFile = new RandomAccessFile(f, "r");
			//��ȡ�ļ���С
			long len = randomFile.length();
			
			System.out.println(len);
			
			
		}
		
		
	}

}
