package com.capgemini.lamdaExpressions;

import java.util.Scanner;

public class CalculatorUI {
	public void menu() {
		Calculator addition       = (num1, num2) -> num1 + num2;
		Calculator Substraction   = (num1, num2) -> num1 - num2;
		Calculator multiplication = (num1, num2) -> num1 * num2;
		Calculator division       = (num1, num2) -> num1 / num2;
		
		//======================================================
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1) Add");
		System.out.println("2) Sub");
		System.out.println("3) Div");
		System.out.println("4) Mul");
		int choice = sc.nextInt();
		
		System.out.println("Enter num1: ");
		int num1 = sc.nextInt();
		
		System.out.println("Enter num2: ");
		int num2 = sc.nextInt();
				
		switch(choice) {
		case 1: performCalculation(addition, num1, num2);break;
		case 2: performCalculation(Substraction, num2, num2);break;
		case 3: performCalculation(multiplication, num1, num2);break;
		case 4: performCalculation(division, num1, num2);break;
		
		default: System.out.println("Invalid Input");break;
		
		}
	}
	
	public void performCalculation(Calculator calc, int num1, int num2){
		int result = calc.operation(num1, num2);
		System.out.println("Result " + result);
	}
	
	public static void main(String[] args) {
		new CalculatorUI().menu();
	}
}
