package Chuwaki;

import java.util.Scanner;

public class Chuwakii {
	private String name;
	Scanner sc = new Scanner(System.in);
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Chuwakii(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name ;
	}
	
}
