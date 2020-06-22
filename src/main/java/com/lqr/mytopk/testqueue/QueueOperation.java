package com.lqr.mytopk.testqueue;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueOperation {

	public static void main(String[] args) {
		int queuemax = 3;
		Queue<String> queue = new ArrayBlockingQueue<String>(queuemax) ;
		
		for (int i = 0; i < 5; i++) {
			if(queue.size()==3) {
				System.out.println(queue.poll());
			}
			queue.add(""+i);
		}
		System.out.println(queue.size());
		for (int i = 0; i < queue.size(); i++) {
			System.out.println(queue.poll());
		}
		
	}

}
