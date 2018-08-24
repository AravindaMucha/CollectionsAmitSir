package com.capgemini.core.junit;

public class SortingArray {
	
	public int[] arraySort(int a[]) {
		
		if(a == null)
			throw new NullPointerException();

		int temp;
		for(int i = 0; i < 5 - 1; i++) {
			for(int j = 0; j < 5 - i - 1; j++) {
				if(a[j] >= a[j + 1]) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
		
		return a;
			
	}
	
}
