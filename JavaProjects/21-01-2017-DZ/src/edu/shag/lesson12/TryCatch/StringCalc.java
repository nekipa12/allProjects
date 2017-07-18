package edu.shag.lesson12.TryCatch;

import java.util.Scanner;

public class StringCalc {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print(">>");
		String str = sc.nextLine();
		String [] result1 = str.split(" ");
		char operator = 0;
		double firstOperand = 0;
		double secondOperand = 0;
		
		try {
			for(int i = 0; i<result1.length; i++) {
				firstOperand = new Double (result1[0]);
				operator = new Character (result1[1].charAt(0));
				secondOperand =  new Double (result1[2]);
			}
		} catch (NumberFormatException nfe) {
				System.out.println("¬ведите корректное значение");
		}
		sc.close();
		System.out.println("= "+Calculator.method(firstOperand, operator, secondOperand));
	}

}
