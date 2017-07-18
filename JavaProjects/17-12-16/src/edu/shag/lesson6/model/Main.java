package edu.shag.lesson6.model;


public class Main 
{

	public static void main(String[] args) 
	{
	
		/*Tire aTire = new Tire(16.5, "", "",100, 110);
		Tire aTire2 = new Tire(14, "", "",100, 160);*/
		
		/*aTire.quality = 95;
		aTire.ride();
		
		System.out.println(aTire.quality);
		
		aTire.repair(5);
		System.out.println(aTire.quality);
		
		aTire2.repair(5);
		System.out.println(aTire2.quality);
		
		Tire.showTire();
		System.out.println(aTire.maxSpeed);*/

		
		
		
		
		//использование приватного доступа геттером и сеттером
		/*aTire.setSize(-20);
		System.out.println(aTire.getSize());*/
		
		
		
		
		
		/*Tire [] tires = new Tire[2];
		tires[0]= new Tire(16.5, "", "",95, 110);
		tires[1]= new Tire(14, "", "",100, 160);
		/*for (int i=0; i<tires.length; i++)
		{
			System.out.println(tires[i].getQuality());
		}
		for (int i=0; i<tires.length; i++)
		{
			//System.out.println(tires[i].toString());//equals
			System.out.println(tires[i]);//equals
		}*/
		
		
		Silo bfShina = new Silo(1, 1, null);
		Tire t1 = new Tire(20, "", "", 100, 150);
		Tire t2 = new Tire(16.5, "", "",100, 110);
		Tire t3 = new Tire(14.5, "", "",100, 110);
		Tire t4 = new Tire(13.5, "", "",100, 110);
		
		bfShina.addTire(t1);
		bfShina.addTire(t2);
		bfShina.addTire(t3);
		bfShina.addTire(t4);
	
		
		Tire wantTire = bfShina.getTire(0);
		if(wantTire!=null) System.out.println(wantTire);
		Tire wantTire2 = bfShina.getTire(20, "", "", 100, 150);
		if(wantTire2!=null) System.out.println(wantTire2);
		
	}

	







}
