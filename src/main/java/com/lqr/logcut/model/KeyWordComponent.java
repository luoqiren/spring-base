package com.lqr.logcut.model;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class KeyWordComponent {
	
	private int preLineNo;
	private int sufLineNo;
	
	private Queue<String> preQueue;
	private Queue<String> sufQueue;
	
	private boolean isFull;
	
	public KeyWordComponent() {
		this.preLineNo=1000;
		this.sufLineNo=1001;
		preQueue = new ArrayBlockingQueue<String>(this.preLineNo);
		sufQueue = new ArrayBlockingQueue<String>(this.sufLineNo);
		isFull = false;
	}
	
	public KeyWordComponent(int preLineNo, int sufLineNo) {
		this.preLineNo=preLineNo;
		this.sufLineNo=sufLineNo;
		preQueue = new ArrayBlockingQueue<String>(this.preLineNo);
		sufQueue = new ArrayBlockingQueue<String>(this.sufLineNo);
		isFull = false;
	}

	public int getPreLineNo() {
		return preLineNo;
	}

	public void setPreLineNo(int preLineNo) {
		this.preLineNo = preLineNo;
	}

	public int getSufLineNo() {
		return sufLineNo;
	}

	public void setSufLineNo(int sufLineNo) {
		this.sufLineNo = sufLineNo;
	}

	public Queue<String> getPreQueue() {
		return preQueue;
	}

	public void setPreQueue(Queue<String> preQueue) {
		this.preQueue = preQueue;
	}

	public Queue<String> getSufQueue() {
		return sufQueue;
	}

	public void setSufQueue(Queue<String> sufQueue) {
		this.sufQueue = sufQueue;
	}

	public boolean isFull() {
		return isFull;
	}

	public void setFull(boolean isFull) {
		this.isFull = isFull;
	}
	
}
