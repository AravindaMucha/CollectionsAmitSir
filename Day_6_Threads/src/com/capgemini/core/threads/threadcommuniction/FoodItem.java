package com.capgemini.core.threads.threadcommuniction;

public class FoodItem 
{
	
	boolean isPlateEmpty = true;

	public synchronized void serve(String foodItem) throws InterruptedException 
	{
			if(isPlateEmpty == false)//--plate is full--- 
			{
				wait();
			}
			
			System.out.println("Food Item Served " + foodItem);
			
			isPlateEmpty = false;
			
			notify();
	}
	
	
	public synchronized void eat(String foodItem) throws InterruptedException 
	{
		if(isPlateEmpty == true)
			wait();
		
		System.out.println("\t\tFood Eaten: " + foodItem);
		
		isPlateEmpty = true;
		
		notify();
		
	}
	
}
