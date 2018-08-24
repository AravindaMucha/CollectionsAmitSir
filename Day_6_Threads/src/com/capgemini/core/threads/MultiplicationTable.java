package com.capgemini.core.threads;

public class MultiplicationTable {
	
	public void multiply() {
		for(int i = 1; i <= 10; i++) {
			int ans = 5 * i;
			System.out.println(Thread.currentThread().getName() + " Prints 5 * " + i + " = " + ans);
			}
		}
	}
