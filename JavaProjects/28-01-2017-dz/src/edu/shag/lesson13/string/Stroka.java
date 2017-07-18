package edu.shag.lesson13.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Stroka {
	
	public static void main(String[] args) {
		
		ArrayList<Character> not = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		for(int i = 0; i < str.length(); i++){
			char c = str.charAt(i);
			if(c != ' ' && c != '.'){
				not.add(c);
			}
		}
		HashMap<Character, Integer> hmst = new HashMap<>();
		Integer equal;
		for(Character s : not){
			equal = hmst.get(s);
			hmst.put(s, equal== null ? 1: equal +1);
		}
		System.out.println("Всего букв "+not.size());
		System.out.println(hmst);
	}
}
