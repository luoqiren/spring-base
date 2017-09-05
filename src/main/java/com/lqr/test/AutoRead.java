package com.lqr.test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

public class AutoRead {
	/**
	 * 此做法比较low
	 * 
	 * java读取文件的事 我怎么能根据我想要的行去读取文件呢 
	 * 比如我想读取文件的第500到1000行网上查到的RandomAccessFile是根据字节来的 不太会用
	 * 我可以传3个参数 path startline endline 返回一个List〈String〉
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
	 * reader.getLineNumber() 从index=0的行开始   [5,8)
	 * @param fullPath 全路径, 包括文件名
	 * @param startLine 起始行, 有大于0的校验
	 * @param endLine 结束行, 传入值大于文件总行数, 以文件行数结束; 需要大于等于startLine
	 * @return List<String>
	 * @throws IOException
	 */
	public static List<String> readFileLine(String fullPath, int startLine, int endLine) throws IOException{
		
		int _startLine = startLine;
		int _endLine = endLine;
		
		List<String> result = new ArrayList<String>();
		if(_endLine < _startLine){
			System.out.println("结束行参数小于起始行参数......");
		}
		
		File file = new File(fullPath);
		if(!file.exists()){
			System.out.println("该文件不存在。");
			return result;
		}
		
		FileReader in = new FileReader(file);  
        LineNumberReader reader = new LineNumberReader(in);
        String str = ""; 
        int index = 0;
        if (_startLine < 0 ) {  
            System.out.println("起始行不在文件的行数范围之内。");  
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
        System.out.println("当前读取到文件最大行:"+(index-1));
		return result;
	}
/*
	// 文件内容的总行数 //没必要
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
