package edu.shag.lesson13.calculator;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class Calculator {
	
	
	static boolean thisOperator(char cha){
		return cha == '+' || cha == '-' || cha == '*' || cha == '/' || cha == '%';
	}
	
	static int priority(char cha) {
		switch (cha) {
		case '+' :
     	case '-':
     		return 1;
     	case '*':
     	case '/':
     	case '%':	
     		return 2;
     	default:
     		return -1;
		}
	}
	
	static void process(Stack<Double> operandS, char cha) {
		
		double r = operandS.pop();
		double l = operandS.pop();
		switch (cha) {
			case '+':operandS.push(l + r);
		     	break;
		    case '-': operandS.push(l - r);
		     	break;
		    case '*': operandS.push(l * r);
		     	break;
		    case '/': operandS.push(l / r);
		     	break;
		    case '%': operandS.push(l % r);
	     	break;	
		     	
		}
	}
	static boolean space(char cha){
		return cha == ' ';
	}
	public static Double workMeth(String stroka){
		Stack<Double> operandS = new Stack<>();
		Stack<Character> operatorS = new Stack<>();
		for (int i =0; i<stroka.length(); i++) {
			char cha = stroka.charAt(i);
			if(space(cha)){
				continue;
			}
			if(thisOperator(cha)){
				while(!operatorS.isEmpty() && priority(operatorS.peek()) >= priority(cha))
					process(operandS, operatorS.pop());
				operatorS.push(cha);
			}else {
				String operand = "";
				while (i<stroka.length() && Character.isDigit(stroka.charAt(i)))
					operand += stroka.charAt(i++);
				--i;
				operandS.push(Double.parseDouble(operand));
			}
		}
		while (!operatorS.isEmpty())
			process(operandS, operatorS.pop());
		System.out.printf("%7.2f", operandS.peek());
		return operandS.peek();
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String stroka = sc.nextLine();
		try{	
			workMeth(stroka);
		}catch(EmptyStackException e){
			System.out.println("ѕусто");
		}catch(NumberFormatException e){
			System.out.println("¬ведите корректное значение");
		}
		sc.close();
	}
}
