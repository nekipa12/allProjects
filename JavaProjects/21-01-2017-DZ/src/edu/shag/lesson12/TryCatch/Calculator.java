package edu.shag.lesson12.TryCatch;

public class Calculator {
	
	public static double method(double firstOperand, char operator, double secondOperand) {
		double result=0;
		switch (operator) {
			case '+':result = firstOperand + secondOperand;
	     		break;
	     	case '-': result = firstOperand - secondOperand;
	     		break;
	     	case '*': result = firstOperand * secondOperand;
	     		break;
	     	case '/': result = firstOperand / secondOperand;
	     		break;
		 }
		 return result;
	}
}
