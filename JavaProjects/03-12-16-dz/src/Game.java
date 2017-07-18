import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Game 
{
	public static void main(String[] args)
	{
		 Random rnd = new Random();
		 int[] arr= new  int [100];
	     for (int i = 0; i<arr.length; i++)
	     {
	    	 arr[i] = rnd.nextInt(30000);				
	     }
	     Arrays.sort(arr);
	     System.out.println("Рандом загадал число от 0 до 30000");
	     int randomChoose = rnd.nextInt(arr.length);
	     Scanner sc = new Scanner(System.in);
	     System.out.println("Отгадайте число которое загадал рандом))");   
	     int playerInput=0;
	     while (playerInput != arr[randomChoose])
	     {
	    	playerInput = sc.nextInt();
	    	 if (playerInput > arr[randomChoose])
	    	 {
	    		System.out.println("Рандом загадал меньше");
	    	 }
	    	 if (playerInput < arr[randomChoose])
	    	 {
	    		System.out.println("Рандом загадал больше");
	    	 }
	    }
	     System.out.println(" Ю ВИННЕР");
	     sc.close(); 
	}
}

