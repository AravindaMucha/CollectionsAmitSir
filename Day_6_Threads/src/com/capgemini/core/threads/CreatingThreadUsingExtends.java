package com.capgemini.core.threads;

class MySurfTabThread extends Thread{
	
	
    Browser browser;

	public MySurfTabThread(Browser browser) {
		this.browser = browser;
	}

	@Override
	public void run() {
		
		browser.surfTab();
		
	}
}

public class CreatingThreadUsingExtends {
	public static void main(String[] args) {
		
		Browser chrome = new Browser();
		
		//---creating one thread---
		MySurfTabThread t1 = new MySurfTabThread(chrome);
		
		
		//---creating two(2nd) thread---
		MySurfTabThread t2 = new MySurfTabThread(chrome);
		
		//---told the thread1 to start work---
		t1.start();
		
		//---told the thread2 to start work---
		t2.start();
	}
}
