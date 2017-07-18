package edu.shag.lesson7.model;

import java.util.Scanner;

public class Main 
{

	public static void main(String[] args) 
	{
		/*Line aLine = new Line(0,0,20,20);
		System.out.println(aLine.toString());
		
		System.out.println(aLine.getDistance());//дистанция между точками
		aLine.drawStars();
		aLine.makeShort();
		aLine.drawDots();*/
		
		
		
		
		//Для оружия
		
		Weapon w; 
		Pistol p = new Pistol(0, 12, 5);
		Bazooka b = new Bazooka(0, 10, 5);
		
		int choise;
		System.out.println("Choose weapon: 0-Pistol, 1-Bazooka");
		Scanner sc = new Scanner(System.in);
		
		
		choise = sc.nextInt();
		if(choise ==0)
		{
			w = p;
		}else
		{
			w = b;
		}
		w.shoot();
		w.reload();
		System.out.println(w.getAmmo());
		if(w instanceof Bazooka)/////////////////////////////
		((Bazooka)w).shoot4();
		
	
	
	
	
	}

}
