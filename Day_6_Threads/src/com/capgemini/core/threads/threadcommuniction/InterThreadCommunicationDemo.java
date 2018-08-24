package com.capgemini.core.threads.threadcommuniction;

public class InterThreadCommunicationDemo {
	public static void main(String[] args) {
		FoodItem foodItem = new FoodItem();
		
		Waiter waiter = new Waiter(foodItem);
		Eater eater = new Eater(foodItem);
		
		waiter.start();
		eater.start();
	}
}
