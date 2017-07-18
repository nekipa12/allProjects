package edu.shag.lesson12.generic;

import java.util.Scanner;

public class GarbageColl {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int [] arr;
		sc.nextInt();
		for(int i=0; i<100000; i++)
			arr = new int[100000];
		sc.nextInt();	
		System.gc();	
		sc.nextInt();	
			
			
		
			

	}

}
