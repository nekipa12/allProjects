package edu.shag.lesson7.dz;

import java.util.Scanner;

public class Main 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("������� 1 ����� ������ ������ ������������ ��������, 2 ����� ������ ������ ������������������ ��������");
		int choose = sc.nextInt();
		if(choose ==1) 
		{
			Passport p = new Passport();
			System.out.println(p.toString());
		}
		else if(choose ==2) 
		{
			InternationalPassport i = new InternationalPassport();
			System.out.println(i.toString());
		}
		sc.close();
	}
}
