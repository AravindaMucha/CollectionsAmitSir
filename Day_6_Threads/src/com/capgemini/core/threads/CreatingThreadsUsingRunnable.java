package com.capgemini.core.threads;

class TaskForDownloaderThread implements Runnable{

	Browser browser;
	
	public TaskForDownloaderThread(Browser browser) {
		this.browser = browser;
	}
	
	@Override
	public void run() {
		browser.downloadFile();
	
	}
}

public class CreatingThreadsUsingRunnable {
	public static void main(String[] args) {
		Browser browser = new Browser();
		TaskForDownloaderThread task = new TaskForDownloaderThread(browser);
		Thread t1 = new Thread(task);
		
		MySurfTabThread t2 = new MySurfTabThread(browser);
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Application Shutting Down....");
	}
}
