package com.lqr.mytopk.ExecutorServiceDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池为无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程
 * @author lqr
 */
public class StudyNewCachedThreadPool {

	public static void main(String[] args) {
		int max = 10;
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		
		for (int i = 0; i < max; i++) {
			final int index = i;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
			cachedThreadPool.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println("I am who I am:"+index);
				}
			});
			
		}
		
	}

}
