package com.lqr.mytopk.CyclicBarrierDemo;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Makers implements Runnable{
	
	private final CyclicBarrier cyclicBarrier;
	private final int makerID;
	private final static Random rand = new Random(80);

	public Makers(CyclicBarrier c, int makerID) {
		this.cyclicBarrier = c;
		this.makerID=makerID;
	}

	@Override
	public void run() {
		int sec = getNoZero();
		try {
			cyclicBarrier.await();
			makerDoWork(sec);
			cyclicBarrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
	
	private void makerDoWork(int sec) throws InterruptedException {
		Thread.sleep(sec*1000);
		System.out.println("我的ID是:"+this.makerID+ ",我花了 " + sec + "秒把敌人甩了" );
	}

	public int getNoZero(){
	    int x =	rand.nextInt(10);
	    while(x==0){
			x=rand.nextInt(10);
		}
		return x;
	}
	
}

class MakerMaster implements Runnable{

	private boolean release ;
	private int maker_num;
	
	public MakerMaster(boolean release, int num) {
		this.release=release;
		this.maker_num=num;
	}
	
	@Override
	public void run() {
		if(this.release){
			System.out.println(maker_num + "个 maker都甩掉敌人");
		}else{
			System.out.println(maker_num + "个 maker正在被敌人跟踪");
			this.release=true;
		}
	}
	
}



public class MyCyclicBarrierTest {
	public static void main(String[] args) {
		int MAX_MAKER=10;
		CyclicBarrier cyclicBarrier = new CyclicBarrier(MAX_MAKER, new MakerMaster(false, MAX_MAKER));
		Thread [] tarr = new  Thread[MAX_MAKER];
		System.out.println("进入战斗模式");
		for (int i = 0; i < MAX_MAKER; i++) {
			tarr[i] = new Thread(new Makers(cyclicBarrier, i));
			tarr[i].start();
			System.out.println("Maker " +i +" 进入状态." + " cyclicBarrier.get:"+cyclicBarrier.getNumberWaiting());
		}
	}

}
