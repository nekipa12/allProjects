package DotCount.edu;

import java.util.Scanner;

public class CountDot {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String [] dot = str.split("");
		String ch = ".";
		int count=0;
		for(int i = 0; i<dot.length; i++) {
			if(dot[i].equals(ch)) {
			count++;
			}
		}
		System.out.println(count);
	}
}
