package com.capgemini.core.logging;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

class Calculator{
	
	static Logger mylogger = Logger.getLogger(Calculator.class);
	
	public int divide(int num1, int num2) {
		mylogger.info("divide method called");
		mylogger.debug("div method called with arguments " +  num1 + "," + num2);
		if(num2 == 0) {
			
			mylogger.error("Exception raised as second argument is " + num2);
			throw new IllegalArgumentException();
		}
		
		mylogger.warn("Attempting to div num1 by num2");
		int result = num1 / num2;
		return result;
	}
}


public class TestLogger {
	public static void main(String[] args) {
		
		PropertyConfigurator.configure("log4j.properties");
		
		int result = new Calculator().divide(12, 2);
		System.out.println("Result : " + result);
	}
}
