package com.lqr.mytopk.ExecutorServiceDemo;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待
 * 因为线程池大小为5，每个任务输出index后sleep 2秒，所以每两秒打印5个数字。
 * 定长线程池的大小最好根据系统资源进行设置。如Runtime.getRuntime().availableProcessors()。可参考PreloadDataCache。
 * @author lqr
 */
public class StudyNewFixedThreadPool {

	public static void main(String[] args) {
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(5);
		int max = 20;
		for (int i = 0; i < max; i++) {
			final int index = i;
			newFixedThreadPool.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println(new Date());
	                try {
	                	System.out.println(index);
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			
		}
		//newFixedThreadPool.shutdown();
	}

}
