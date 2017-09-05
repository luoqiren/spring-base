package com.lqr.test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

public class AutoRead {
	/**
	 * �������Ƚ�low
	 * 
	 * java��ȡ�ļ����� ����ô�ܸ�������Ҫ����ȥ��ȡ�ļ��� 
	 * ���������ȡ�ļ��ĵ�500��1000�����ϲ鵽��RandomAccessFile�Ǹ����ֽ����� ��̫����
	 * �ҿ��Դ�3������ path startline endline ����һ��List��String��
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String s = "C:\\Users\\lqr\\Desktop\\Test.txt";
		
		List<String> list = readFileLine(s, 5, 8);
		
		for (String str: list) {
			System.out.println(str);
		}
	}

	/**
	 * reader.getLineNumber() ��index=0���п�ʼ   [5,8)
	 * @param fullPath ȫ·��, �����ļ���
	 * @param startLine ��ʼ��, �д���0��У��
	 * @param endLine ������, ����ֵ�����ļ�������, ���ļ���������; ��Ҫ���ڵ���startLine
	 * @return List<String>
	 * @throws IOException
	 */
	public static List<String> readFileLine(String fullPath, int startLine, int endLine) throws IOException{
		
		int _startLine = startLine;
		int _endLine = endLine;
		
		List<String> result = new ArrayList<String>();
		if(_endLine < _startLine){
			System.out.println("�����в���С����ʼ�в���......");
		}
		
		File file = new File(fullPath);
		if(!file.exists()){
			System.out.println("���ļ������ڡ�");
			return result;
		}
		
		FileReader in = new FileReader(file);  
        LineNumberReader reader = new LineNumberReader(in);
        String str = ""; 
        int index = 0;
        if (_startLine < 0 ) {  
            System.out.println("��ʼ�в����ļ���������Χ֮�ڡ�");  
        }else{
//        	reader.setLineNumber(_startLine);
        	while(str!=null && reader.getLineNumber()<_endLine){
        		System.out.println("currentline(start with 0) :"+reader.getLineNumber());
        		str = reader.readLine();
        		index++;
        		if(index>=_startLine && index<_endLine){
        			System.out.println("line "+reader.getLineNumber() +"has add");
        			result.add(str);
        		}
        	}
        	
        }
        reader.close();
        in.close();
        System.out.println("��ǰ��ȡ���ļ������:"+(index-1));
		return result;
	}
/*
	// �ļ����ݵ������� //û��Ҫ
	private static int getTotalLines(File file) throws IOException {
		FileReader in = new FileReader(file);  
        LineNumberReader reader = new LineNumberReader(in);  
        String s = reader.readLine();  
        int lines = 0;  
        while (s != null) {  
            lines++;  
            s = reader.readLine();  
        }  
        reader.close();  
        in.close();  
        return lines;  
	}*/
}
