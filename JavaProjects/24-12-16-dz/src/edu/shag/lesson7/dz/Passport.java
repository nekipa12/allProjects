package edu.shag.lesson7.dz;

import java.util.Scanner;

public class Passport extends PassportParent
{	/**
	*מעקוסעגמ
	*/
	private String secondName;

	public String getSecondName() 
	{
		return secondName;
	}
	public void setSecondName(String secondName) 
	{
		this.secondName = secondName;
	}
	
	@Override
	public String toString() 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("input second name");
		this.secondName = sc.nextLine();
		//sc.close();
		return "Passport "+super.toString()+("secondName=" + secondName + "");
	}
}
