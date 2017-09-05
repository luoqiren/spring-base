package com.lqr.test;

import java.io.File;

public class FileTest2 {

	public static void main(String[] args)  {
		File f = new File("D:\\a.tmp");
		File f2 = new File("D:\\a.csv");
		if(f.exists() && !f2.exists()){
			f.renameTo(f2);
		}
		
        
	}

}
