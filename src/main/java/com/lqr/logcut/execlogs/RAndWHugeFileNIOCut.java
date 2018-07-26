package com.lqr.logcut.execlogs;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Queue;

import com.lqr.logcut.model.KeyWordComponent;

/**
 * NIO读取百万级别文件
 * 这个很厉害
 * 增加参数设定， 可以读取指定关键字前后各N行数据
 */
public class RAndWHugeFileNIOCut {

/*	private static String FILE_PATH = "C:\\Users\\lqr\\Documents\\nohup.out";
	private static String TARGET_FILE_PATH_2 = "E:\\testlogs\\nohup.out.20180724_001.txt";*/
	
	private static int DEFAULT_PRE_LINE_NO = 1000;
	private static int DEFAULT_SUF_LINE_NO = 1001;//排除关键词那一行
	
	private static String DEFAULT_KEY_WORLD = "18MAIC01010180719015080";
	/*public static void main(String args[]) throws Exception {

		int bufSize = 5*1024*1024;//一次读取的字节长度  5M
		File fin = new File(FILE_PATH);//读取的文件
		File fout = new File(TARGET_FILE_PATH_2);//写出的文件
		Date startDate = new Date();
		FileChannel fcin = new RandomAccessFile(fin, "r").getChannel();
		ByteBuffer rBuffer = ByteBuffer.allocate(bufSize);

		FileChannel fcout = new RandomAccessFile(fout, "rws").getChannel();
		ByteBuffer wBuffer = ByteBuffer.allocateDirect(bufSize);

		readFileByLine(bufSize, fcin, rBuffer, fcout, wBuffer);
		Date endDate = new Date();
		
		System.out.print(startDate+"|"+endDate);//测试执行时间
		if(fcin.isOpen()){
			fcin.close();
		}
		if(fcout.isOpen()){
			fcout.close();
		}
		fcin = null;
		fcout = null;
	}*/
	
	public static String cutTheKeyWorldLogs(String logFileAbsPath, String outputFilePath, int preLineNo, int sufLineNo, String keyWorld) throws Exception {
		
		DEFAULT_PRE_LINE_NO = preLineNo;
		DEFAULT_SUF_LINE_NO = sufLineNo;
		DEFAULT_KEY_WORLD = keyWorld;
		
		int bufSize = 5*1024*1024;//一次读取的字节长度  5M
		File fin = new File(logFileAbsPath);//读取的文件
		File fout = new File(outputFilePath+"\\"+System.currentTimeMillis()+".txt");//写出的文件
		
		Date startDate = new Date();
		FileChannel fcin = new RandomAccessFile(fin, "r").getChannel();
		ByteBuffer rBuffer = ByteBuffer.allocate(bufSize);

		FileChannel fcout = new RandomAccessFile(fout, "rws").getChannel();
		ByteBuffer wBuffer = ByteBuffer.allocateDirect(bufSize);

		readFileByLine(bufSize, fcin, rBuffer, fcout, wBuffer);
		Date endDate = new Date();
		
		System.out.print(startDate+"|"+endDate);//测试执行时间
		if(fcin.isOpen()){
			fcin.close();
		}
		if(fcout.isOpen()){
			fcout.close();
		}
		fcin = null;
		fcout = null;
		return "success";
	}
	

	private static void readFileByLine(int bufSize, FileChannel fcin,
			ByteBuffer rBuffer, FileChannel fcout, ByteBuffer wBuffer) {
		String enter = "\n";
		byte[] lineByte = new byte[0];
		
		/*Queue<String> preQueue = new ArrayBlockingQueue<String>(DEFAULT_PRE_LINE_NO);
		List<String>  sufList = new ArrayList<String>(DEFAULT_SUF_LINE_NO);*/
		
		List<KeyWordComponent> resultList = new ArrayList<KeyWordComponent>();
		KeyWordComponent keyWordComponent = new KeyWordComponent(DEFAULT_PRE_LINE_NO, DEFAULT_SUF_LINE_NO);
		Queue<String> preQueue = keyWordComponent.getPreQueue();
		Queue<String> sufQueue = keyWordComponent.getSufQueue();
		boolean hitTheKeyWorld = false;
		
		String encode = "GBK";
		try {
			//temp：由于是按固定字节读取，在一次读取中，第一行和最后一行经常是不完整的行，因此定义此变量来存储上次的最后一行和这次的第一行的内容，
			//并将之连接成完成的一行，否则会出现汉字被拆分成2个字节，并被提前转换成字符串而乱码的问题
			byte[] temp = new byte[0];
			while (fcin.read(rBuffer)!=-1) {//fcin.read(rBuffer)：从文件管道读取内容到缓冲区(rBuffer)
//			while (fcin.read(rBuffer)!=-1 && sufList.size()!=DEFAULT_SUF_LINE_NO) {//fcin.read(rBuffer)：从文件管道读取内容到缓冲区(rBuffer)
				int rSize = rBuffer.position();//读取结束后的位置，相当于读取的长度
				byte[] bs = new byte[rSize];//用来存放读取的内容的数组
				rBuffer.rewind();//将position设回0,所以你可以重读Buffer中的所有数据,此处如果不设置,无法使用下面的get方法
				rBuffer.get(bs);//相当于rBuffer.get(bs,0,bs.length())：从position初始位置开始相对读,读bs.length个byte,并写入bs[0]到bs[bs.length-1]的区域
				rBuffer.clear();
				
				int startNum = 0;
				int LF = 10;//换行符
				int CR = 13;//回车符
				boolean hasLF = false;//是否有换行符
				for(int i = 0; i < rSize; i++){
					if(bs[i] == LF){
						//
						if(keyWordComponent.isFull()) {
							hitTheKeyWorld = false;
							resultList.add(keyWordComponent);
							keyWordComponent = new KeyWordComponent(DEFAULT_PRE_LINE_NO, DEFAULT_SUF_LINE_NO);
							preQueue = keyWordComponent.getPreQueue();
							sufQueue = keyWordComponent.getSufQueue();
						}
						
						hasLF = true;
						int tempNum = temp.length;
						int lineNum = i - startNum;
						lineByte = new byte[tempNum + lineNum];//数组大小已经去掉换行符
						
						System.arraycopy(temp, 0, lineByte, 0, tempNum);//填充了lineByte[0]~lineByte[tempNum-1]
						temp = new byte[0];
						System.arraycopy(bs, startNum, lineByte, tempNum, lineNum);//填充lineByte[tempNum]~lineByte[tempNum+lineNum-1]
						
						String line = new String(lineByte, 0, lineByte.length, encode);//一行完整的字符串(过滤了换行和回车)
						//如果想使用TopK 算法,进行统计, 此处应该做点什么东西?
						//dataList.add(line);
						
						//碰见关键词 start
						if(line.contains(DEFAULT_KEY_WORLD)) {
							hitTheKeyWorld = true;
						}
						//碰见关键词 end
						
						//将没碰到关键词之前, 前置的数据弄进到要输出的队列里 start
						if(!hitTheKeyWorld) {
							if(preQueue.size()==DEFAULT_PRE_LINE_NO) {
								preQueue.poll();
							}
							preQueue.add(line);
						}
						//将没碰到关键词之前, 前置的数据弄进到要输出的队列里 end
						
						//碰见关键词后开始统计 start
						if(hitTheKeyWorld && sufQueue.size()<DEFAULT_SUF_LINE_NO) {
							sufQueue.add(line);
						}
						
						if(sufQueue.size()==DEFAULT_SUF_LINE_NO) {
							keyWordComponent.setFull(true);
						}
						//碰见关键词后开始统计 end
//						System.out.println(line);
						//writeFileByLine(fcout, wBuffer, line + enter);
						
						//过滤回车符和换行符
						if(i + 1 < rSize && bs[i + 1] == CR){
							startNum = i + 2;
						}else{
							startNum = i + 1;
						}
						
					}
				}
				if(hasLF){
					temp = new byte[bs.length - startNum];
					System.arraycopy(bs, startNum, temp, 0, temp.length);
				}else{//兼容单次读取的内容不足一行的情况
					byte[] toTemp = new byte[temp.length + bs.length];
					System.arraycopy(temp, 0, toTemp, 0, temp.length);
					System.arraycopy(bs, 0, toTemp, temp.length, bs.length);
					temp = toTemp;
				}
			}
			if(temp != null && temp.length > 0){//兼容文件最后一行没有换行的情况
				String line = new String(temp, 0, temp.length, encode);
				//如果想使用TopK 算法,进行统计, 此处应该做点什么东西?
				if(hitTheKeyWorld && sufQueue.size()<DEFAULT_SUF_LINE_NO) {
					sufQueue.add(line);
				}
			}
			//所有循环都结束后，若不满足 isfull的要求，又已经包含关键字， 仍然要加入list中方便打印
			if(!keyWordComponent.isFull() && keyWordComponent.getSufQueue().size()>0) {
				resultList.add(keyWordComponent);
			}
			
			for (int j = 0; j < resultList.size(); j++) {
				KeyWordComponent kwc = resultList.get(j);
				Queue<String> preQ=kwc.getPreQueue();
				Queue<String> sufQ=kwc.getSufQueue();
				int preSize = preQ.size();
				int sufSize = sufQ.size();
				writeFileByLine(fcout, wBuffer, "["+getCurrentUtilDateFormatString()+"]-start-------------------------"+j+"-----------------------------------start-" + enter);
				for (int k = 0; k < preSize; k++) {
					writeFileByLine(fcout, wBuffer, preQ.poll() + enter);
				}
				for (int l = 0; l < sufSize; l++) {
					writeFileByLine(fcout, wBuffer, sufQ.poll() + enter);
				}
				writeFileByLine(fcout, wBuffer, "["+getCurrentUtilDateFormatString()+"]-end-------------------------"+j+"-----------------------------------end-" + enter);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	/**
	 * 写到文件上
	 * @param fcout
	 * @param wBuffer
	 * @param line
	 */
	@SuppressWarnings("static-access")
	public static void writeFileByLine(FileChannel fcout, ByteBuffer wBuffer,
			String line) {
		try {
			fcout.write(wBuffer.wrap(line.getBytes("GBK")), fcout.size());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getCurrentUtilDateFormatString(){
		Format format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date date = new java.util.Date();
		return format.format(date);
	}
}