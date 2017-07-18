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
		catch(Exception exc) {//его задача вернуть программу в нормальное русло, чтобы она могла продолжитьс€
			
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
			size = sc.nextInt();//массив отрицательной длинны
			int[] arr = new int[size];
			arr[20] = 5;
		}
		catch(Exception e){
			e.printStackTrace();
		}*/
		
		/////////////////////////////////////////////////////////////////////////////////////////
		
		
		
	/*	try{
			
			int[] arr = new int[5];//ошибка вышел за пределы массива
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
		finally { 	//выполн€ет освобождение ресурсов, гарантирует что всЄ будет норм.
			
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
/*public static void method() throws Exception{//ключевое слово throws включает дл€ метода обработчик по умолчанию, 
												//который выполн€ет трассировку стеков вызова дл€ вслего метода
	Scanner sc = new Scanner(System.in);
	int a = sc.nextInt();
	System.out.println(5/a);
}*/
}
