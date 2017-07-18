package edu.shag.lesson7.dz3;
public class Main 
{

	public static void main(String[] args) 
	{
		Study[] s = new Study[5];
		s[0] = new Study("Simpson", "Gomer");
		s[1] = new Study("Simpson", "Bart");
		s[2] = new Study("Simpson", "Lisa");
		s[3] = new Study("Griffin", "Petter");
		s[4] = new Study("Gerrard", "Cooper");
		int z = 0;
		for(Study stud : s)
		{
			System.out.println(stud.toString());
			z++;
		}
		System.out.println("Всего студентов "+z);
		
		Absolvent[] a = new Absolvent[4];
		a[0] = new Absolvent("Goover", "Games", 45);
		a[1] = new Absolvent("Upkin", "Billy", 46);
		a[2] = new Absolvent("Clock", "Sunny", 47);
		a[3] = new Absolvent("Pipper", "Petter", 48);
		int c = 0;
		for(Absolvent abs : a)
		{
			System.out.println(abs.toString());
			c++;
		}
		System.out.println("Всего аспирантов "+c);
	}
}
