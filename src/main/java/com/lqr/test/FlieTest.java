package com.lqr.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class FlieTest {

	public static void main(String[] args) throws IOException {
		File f = new File("D:\\a.tmp");
		if(!f.exists()){
			f.createNewFile();
		}
		
		FileOutputStream out = new FileOutputStream(f, true);
		OutputStreamWriter osw = new OutputStreamWriter(out, "GBK");
		BufferedWriter bw = new BufferedWriter(osw);
		
		bw.write("AAA,°¡°¡°¡°¡, Éµ±Æ°¡, !!!, ÖÐÎÄ");
		bw.write("AAA,°¡°¡°¡°¡, Éµ±Æ°¡, !!!, ÖÐÎÄ");
		bw.write("AAA,°¡°¡°¡°¡, Éµ±Æ°¡, !!!, ÖÐÎÄ");
		bw.flush();
		
		bw.close();
	}

}
