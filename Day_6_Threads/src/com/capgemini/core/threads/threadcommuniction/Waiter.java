package com.capgemini.core.threads.threadcommuniction;

public class Waiter extends Thread{
	
	String[] foodList = new String[] {"Samosa", "Idli", "Wada"};
	FoodItem foodItem;
	
	public Waiter(FoodItem foodItem) {
		super();
		this.foodItem = foodItem;
	}
	
	@Override
	public void run() {
		for(int count = 0; count < foodList.length; count++) {
			
			try {
				foodItem.serve(foodList[count]);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
}
