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
	     System.out.println("������ ������� ����� �� 0 �� 30000");
	     int randomChoose = rnd.nextInt(arr.length);
	     Scanner sc = new Scanner(System.in);
	     System.out.println("��������� ����� ������� ������� ������))");   
	     int playerInput=0;
	     while (playerInput != arr[randomChoose])
	     {
	    	playerInput = sc.nextInt();
	    	 if (playerInput > arr[randomChoose])
	    	 {
	    		System.out.println("������ ������� ������");
	    	 }
	    	 if (playerInput < arr[randomChoose])
	    	 {
	    		System.out.println("������ ������� ������");
	    	 }
	    }
	     System.out.println(" � ������");
	     sc.close(); 
	}
}

