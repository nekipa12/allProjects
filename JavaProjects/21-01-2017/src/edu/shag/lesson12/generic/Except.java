package edu.shag.lesson12.generic;

import java.util.Scanner;

public class Except {

	
	public static void main(String[] args) {
		
		/*int a=0;
		Scanner sc = new Scanner(System.in);
		try {
			a = sc.nextInt();
			System.out.println(5/a);
		} 
		catch(Exception exc) {//��� ������ ������� ��������� � ���������� �����, ����� ��� ����� ������������
			
			//exc.printStackTrace();
		}
		a++;
		System.out.println("Done");*/
		
		/////////////////////////////////////////////////////////////////////////////////////////////

		/*System.out.println("1");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		System.out.println("2");*/
		
		////////////////////////////////////////////////////////////////////////////////////
		
		/*Scanner sc = new Scanner(System.in);
		int size = 0;
		try{
			size = sc.nextInt();//������ ������������� ������
			int[] arr = new int[size];
			arr[20] = 5;
		}
		catch(Exception e){
			e.printStackTrace();
		}*/
		
		/////////////////////////////////////////////////////////////////////////////////////////
		
		
		
	/*	try{
			
			int[] arr = new int[5];//������ ����� �� ������� �������
			arr[20] = 5;
		}
		catch(Exception e){
			e.printStackTrace();
		}*/
		
		/////////////////////////////////////////////////////////////////////////////////////////////
		
		/*int a=0;
		Scanner sc = new Scanner(System.in);
		try {
			a = sc.nextInt();
			System.out.println(5/a);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally { 	//��������� ������������ ��������, ����������� ��� �� ����� ����.
			
			System.out.println("Finally");
			sc.close();
		}
		System.out.println("OK");*/
		
		////////////////////////////////////////////////////////////////////////////////////////////////
		
		/*try {
			method();
		} catch (Exception e) {
			//e.printStackTrace();
		}
		System.out.println("Finish");*/
		
		//////////////////////////////////////////////////////////////////////////////////////////////////
		
		/*int a ;
		Scanner sc = new Scanner(System.in);
		
		try{
			a = sc.nextInt();
			if(a<0) throw new Exception("myMessage");
			System.out.println("1");
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
			sc.close();
		}
		System.out.println("2");*/
		
		
		
		
		
	}
/*public static void method() throws Exception{//�������� ����� throws �������� ��� ������ ���������� �� ���������, 
												//������� ��������� ����������� ������ ������ ��� ������ ������
	Scanner sc = new Scanner(System.in);
	int a = sc.nextInt();
	System.out.println(5/a);
}*/
}
