package Chuwaki;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Main {
	
	public static void method(HashMap<String, String> sch) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Key");
			String c = sc.nextLine();
			if(c.equals("no")) {
				sc.close();
				return;
			}
			System.out.println("input name");
			ArrayList<Chuwakii> al = new ArrayList<>();
			while (true) {
				String name = sc.nextLine();
				if(name.equals("no")) {
					break;
				}
				Chuwakii f =new Chuwakii(name);
				al.add(f);
				sch.put(c, al.toString());
			}
		}
	}
	
	public static void main(String[] args) {
		
		HashMap<String, String> sch = new HashMap<>();
		method(sch);
		Set<Entry<String, String>> set = sch.entrySet();
		for(HashMap.Entry<String, String> me : set) {
			System.out.print(me.getKey() + ":");
			System.out.println(me.getValue());
		}
	}
}
