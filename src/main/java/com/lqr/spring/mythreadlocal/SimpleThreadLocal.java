package com.lqr.spring.mythreadlocal;
/**
 * ThreadLocal 为每个线程提供单独副本 小证明
 * @author lqr
 *
 */
public class SimpleThreadLocal {

	private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>(){
		public Integer initialValue(){
			return 0;
		}
	};
	
	public int getNextNum(){
		seqNum.set(seqNum.get()+1);
		return seqNum.get();
	}
	
	public static void main(String[] args) {
		SimpleThreadLocal simpleThreadLocal = new SimpleThreadLocal();
		
		//每个线程都共享了一个simpleThreadLocal的实例，产生的结果并没有互相干扰，各自产生的独立的序列号
		//这个是因为每个线程提供了单独的副本
		TestClient tc1 = new TestClient(simpleThreadLocal);
		TestClient tc2 = new TestClient(simpleThreadLocal);
		TestClient tc3 = new TestClient(simpleThreadLocal);
		
		tc1.start();
		tc2.start();
		tc3.start();
	}
	
	private static class TestClient extends Thread{
		private SimpleThreadLocal stl;

		public TestClient(SimpleThreadLocal stl) {
			this.stl = stl;
		}

		@Override
		public void run() {
			for (int i = 0; i < 3; i++) {
				System.out.println("我是线程:"+Thread.currentThread().getName() +"| 序列号是:"+stl.getNextNum());
			}
		}
		
		
	} 

}
