import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class main 
{

	public static void main(String[] args) 
	{
		
		
		
		/*int[] arr= new  int [10];
		Random rnd = new Random();
		for (int i = 0; i<arr.length; i++)
		{
			 arr[i] = rnd.nextInt(20);
		}
		
		for (int i = arr.length-1; i>0; i--)
		{
			for (int j = 0; j<i; j++)
			{
				if(arr [j] > arr[j+1])
				{
					int tmp = arr[j];
					arr[j]= arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
	
		for (int i = 0; i<arr.length; i++)
		{
			System.out.print(arr[i] + "\t");	// sortirovka
		}*/
	
	
		
		
		/*int[] arr= new  int [10];
		Random rnd = new Random();
		for (int i = 0; i>arr.length; i++)
		{
			int min = arr[i];
			int min_i = i;
			for (int j = i+1; j<arr.length; j++)
			{
				if (arr [j]<min)
				{
					min =arr[j];
					 min_i = j;
				}
			}
			if (i!=min)
			{
				int tmp = arr[i];
				arr[i] = arr[min_i];
				arr [min_i]= tmp;
			}
		
		 
		}*/

	
		
		
		/*int[] arr= new  int [10];
		Random rnd = new Random();
		for (int i = 0; i<arr.length; i++)
		{
			 arr[i] = rnd.nextInt(20);
		}
		Arrays.sort(arr); //вызов стандартной функции быстрой сортировки
		
		for (int i = 0; i<arr.length; i++)
		{
			 System.out.print(arr[i] + "\t");
		}*/
		
		
		
		
		
		//https://www.cs.usfca.edu/~galles/visualization/Search.html
		
		/*int[] arr= new  int [10];
		Random rnd = new Random();
		for (int i = 0; i<arr.length; i++)
		{
			 arr[i] = rnd.nextInt(20);
		}
		Scanner sc = new Scanner (System.in);	//Линейный алгоритм поиска
		int elementSearch = sc.nextInt();
		sc.close();
		for (int i = 0; i<arr.length; i++)
		{
			if (arr[i] ==elementSearch)
			{
				
				System.out.println("Found " + elementSearch + " it`s number " + i);
				break;
			}
		}*/
		
	
	
	
	
		/*int[] arr= new  int [10];
		Random rnd = new Random();
		for (int i = 0; i<arr.length; i++)
		{
			 arr[i] = rnd.nextInt(20);				//бинарный поиск
		}
		Scanner sc = new Scanner (System.in);	
		int elementSearch = sc.nextInt();
		Arrays.sort(arr);
		int first = 0, last = arr.length-1;
		int position = (first + last) /2;  //(int) (arr.lengt/2)
		 while ((arr [position]!=elementSearch ) && (first <= last))
		 {
			 if (arr [position] > elementSearch)
			 {
				 last = position-1;// отброс правой половины
			 }else first = position+1;// отброс левой половины
			  position =(first + last) /2; // смещение средины
			 
		 }	
		 if (first <= last)
		 {
			 System.out.println(elementSearch + " находится на " + ++position + " позиции ");
		 }
		 else 
		 {
			 System.out.println(" Элемент не найден ");
		 }*/
		
		
		
		
		
		
		
		
		/*String str = "hello";   //= - перегруженный оператор
		String str2 = str;
		str2+=" , world";
		System.out.println(str);
		System.out.println(str2);
		
		System.gc(); //сборщик мусора*/
		
		
		
		
		
		//СТРОКОВАЯ
		
		/*String s = "55,5";
		int a = Integer.parseInt(s);  // преобразовывает в int
		a++;
		System.out.println(a);// строка в число
		
			
		double d = Double.parseDouble(s);
		d*=1.1;
		System.out.println(d);
		
		int b = 20;
		String ss = String.valueOf(b);
		System.out.println(ss);
		
		String sss = "" + b;
		System.out.println(ss);
		*/
		
		
	
		
	
			
		
		
		//получение символа из строки
	//	String s = "abcdefgh";
		//for (int i = 1; i < s.length(); i+=2) 
		//{
		//	System.out.print(s.charAt(i) + "\t");
		//}
		
		//СРАВНЕНИЕ СТРОК
		//Scanner sc = new Scanner (System.in);
		//String s2 = sc.nextLine();
		//if (s.equals(s2))// не равенство а факт того что две ссылки смотрят на один и тот же участок оперативы
		
		//{
			//System.out.println(" Strings are equal");
		//}
		/*if (s.contains("def"))
		{
			System.out.println("def+"); 
		}
		
		
		if (s.startsWith("a"))
		{
			System.out.println("a+");
		}
		
		if (s.endsWith("f"))
		{
			System.out.println("f");
		}*/
		
		//int index=s.indexOf("cde");
		//System.out.println(index); //проверка последовательности
		
		
		/*String str = " AA BB CC DD EEE FFFFF GGGGGG";
		String [] strings=str.split("");
		
		for (int i = 0; i < strings.length; i++)
		{
			System.out.print(strings[i]);
		}
		
		
		String str2=str.toLowerCase();
		String str3=str.toUpperCase();
		if(str2.equals(str3))
		{
			System.out.println(" equal");
		}*/
		
		
		//Обьединение строк через разделитель
		//String ss = String.join("k", "1","2","3");
		//System.out.println(ss);
		
	
		//форм вывод строки
		//System.out.printf("Hello %d world %f %c\n", 5,15.5, 's');
		
		
		
		
		//StringBuilder 				//class
		/*String s="";
		for (int i = 0; i < 10; i++)
		{
			s+=String.valueOf(i) + " ";
		}
		System.out.println(s);*/
		
		
		/*StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10; i++)
		{
			sb.append(String.valueOf(i));
			sb.append("	");
		}
		System.out.println(sb.toString());*/
		
		
		
		//StringBuffer
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}



}
