package edu.shag.lesson8.model;

import java.util.Arrays;

public class Main 
{

	public static void main(String[] args) 
	{
		
		Staff[] aStaff = new Staff[7];
		aStaff[0] = new Disc(10.5, "D1", "Usa", 100, "dvd");
		aStaff[1] = new Disc(15.5, "D8", "Canada", 105, "dvi");
		aStaff[2] = new Disc(9.5, "D7", "Cana", 30, "avi");
		aStaff[3] = new Disc(105.5, "D28", "UA", 1000, "dvi, dvd");
		aStaff[4] = new Disc(145.5, "D58", "China", 60, "dvi, mp4");
		aStaff[5] = new Apple(800, "Красивое", "USA", "green", "не вкусные");
		aStaff[6] = new Apple(6.0, "не красивое","UA", "red", "вкусные" );
		
		Arrays.sort(aStaff);
		
		for(Staff s : aStaff)// новый цикл for each
		{
			s.setPrice(s.getPrice()* 0.9);
			System.out.println(s.toString());
		}
		Apple a = new Apple(100000, null, null, null, null);
		System.out.println(a.compareTo(a));
	}
}
