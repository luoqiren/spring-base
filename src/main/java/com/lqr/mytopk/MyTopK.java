package com.lqr.mytopk;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class MyTopK {

	private static String FILE_PATH = "E:\\testlogs\\nohup.out";
	private static String TARGET_FILE_PATH = "E:\\testlogs\\copy.txt";

	private static void lagerFileReadPerLine(File lagerFile) {
		if (lagerFile != null && lagerFile.exists()) {
			try {
				int lineNum = 0;
				// 此处开销太大，对大文件读取不建议使用
				BufferedInputStream bis = new BufferedInputStream(new FileInputStream(lagerFile));
				BufferedReader in = new BufferedReader(new FileReader(lagerFile));// 10M缓存
				BufferedWriter bw = new BufferedWriter(new FileWriter(new File(TARGET_FILE_PATH)));
				// BufferedReader in = new BufferedReader(new
				// InputStreamReader(bis, "utf-8"));//10M缓存

				String line = "";
				long startTime = System.currentTimeMillis();
				while ((line = in.readLine()) != null && lineNum <10000) {
					System.out.println(line);
					lineNum++;
					bw.write(line);
					bw.newLine();
				}
				long endTime = System.currentTimeMillis();
				in.close();
				bw.close();
				System.out.println("读完这个文件花费:" + ((endTime - startTime) / 1000) + " 秒");

				/*ByteBuffer byteBuf = ByteBuffer.allocate(1024 * 10 * 1024);  
				byte[] bbb = new byte[100 * 10 * 1024];  
				RandomAccessFile fis = new RandomAccessFile(FILE_PATH, "rw");  
				RandomAccessFile fos = new RandomAccessFile(TARGET_FILE_PATH,"rw");  
				FileChannel fc = fis.getChannel();  
				long timeStar = System.currentTimeMillis();// 得到当前的时间  
				fc.read(byteBuf);// 1 读取  
//				MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size());  
				System.out.println(fc.size()/1024);  
				long timeEnd = System.currentTimeMillis();// 得到当前的时间  
				System.out.println("Read time :" + (timeEnd - timeStar) + "ms");  
				timeStar = System.currentTimeMillis();  
				fos.write(byteBuf.array());//2.写入  
//				fos.writeUTF(new String(byteBuf.array(),"UTF-8"));
//				mbb.force(); 
//				mbb.clear();
				timeEnd = System.currentTimeMillis();  
				System.out.println("Write time :" + (timeEnd - timeStar) + "ms");  
				fos.close();  
				fc.close();  
				fis.close();  
//				fc = null;
*/				
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("不存在对应文件");
		}

	}

	public static void main(String[] args) {
		File lagerFile = new File(FILE_PATH);
		lagerFileReadPerLine(lagerFile);
	}

}
