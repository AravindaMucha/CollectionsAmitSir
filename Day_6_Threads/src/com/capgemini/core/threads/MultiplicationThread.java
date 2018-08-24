package com.capgemini.core.threads;

class ThreadMultiply implements Runnable{

	MultiplicationTable mt;
	
	public ThreadMultiply(MultiplicationTable mt) {
		this.mt = mt;
	}
	
	@Override
	public void run() {
		mt.multiply();
	}
	
}

public class MultiplicationThread {
	
	public static void main(String[] args) {
		MultiplicationTable mt = new MultiplicationTable();
		ThreadMultiply task = new ThreadMultiply(mt);
		Thread t1 = new Thread(task);
		t1.start();
		
		
	}
}
