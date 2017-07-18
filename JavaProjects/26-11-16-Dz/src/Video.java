import java.util.Random;
import java.util.Scanner;


public class Video 
{	
	public static void main(String[] args) 
	{	
		
		
		
		Random rnd = new Random();
		int [][][] vid = new int [3][9][16]; 
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 9 ; j++)
			{
				for (int k = 0 ; k < 16 ; k++)
				{
					vid[i][j][k] = rnd.nextInt(256);
					System.out.print(vid[i][j][k]+ "\t"  );
				}
				System.out.println();
			}
			System.out.println();
		}
		System.out.println("10-й пиксеь до фильтрации- ");
		
		for (int i = 0; i < 1; i++)
		{
			for (int j = 0; j < 1 ; j++)
			{
				for (int k = 9; k < 10; k++)
				{
					System.out.println("RED "+ "\t" + vid[i][j][k]);
				}
			}
		}
		
		for (int i = 1; i < 2; i++)
		{
			for (int j = 0; j < 1 ; j++)
			{
				for (int k = 9; k < 10; k++)
				{
					System.out.println("GREEN " + "\t"+ vid[i][j][k] );
				}
			}
		}
		
		for (int i = 2; i < 3; i++)
		{
			for (int j = 0; j < 1 ; j++)
			{
				for (int k = 9; k < 10; k++)
				{
					System.out.println("BLUE " + "\t" + vid[i][j][k]);
				}
			}
		}
		
		
		
		System.out.println();
		Scanner sc = new Scanner (System.in);
		System.out.print("Введите число на которое нужно повысить интенсивность всех цветов-");
		int ab = sc.nextInt();
		sc.close();
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 9 ; j++)
			{
				for (int k = 0 ; k < 16 ; k++)
				{
					vid[i][j][k]+=ab;
					if(vid[i][j][k]>256)
					{	
						vid[i][j][k]=256;
					}
					System.out.print(vid[i][j][k]+"\t");
				}
				System.out.println();
			}
			System.out.println();
		}
		
		
		
		System.out.println("10-й пиксеь после фильтрации- ");
		for (int i = 0; i < 1; i++)
		{
			for (int j = 0; j < 1 ; j++)
			{
				for (int k = 9; k < 10; k++)
				{
					System.out.println("RED "+ "\t" + vid[i][j][k]);
				}
			}
		}
		
		for (int i = 1; i < 2; i++)
		{
			for (int j = 0; j < 1 ; j++)
			{
				for (int k = 9; k < 10; k++)
				{
					System.out.println("GREEN " + "\t"+ vid[i][j][k] );
				}
			}
		}
		
		for (int i = 2; i < 3; i++)
		{
			for (int j = 0; j < 1 ; j++)
			{
				for (int k = 9; k < 10; k++)
				{
					System.out.println("BLUE " + "\t" + vid[i][j][k]);
				}
			}
		}
		
		
		
		System.out.println();
		System.out.println("Средняя насыщеность матрицы составит-");
		int sum;
		for (int i = 0; i < 3; i++)
		{ 
			sum = 0;
			for (int j = 0; j < 9; j++)
			{
				for (int k = 0 ; k < 16; k++)
				{
					sum +=vid[i][j][k];
				
					//sum /=vid[j]*vid[k];
				}
			}
				
			
				
			System.out.println(sum/144);
		}
		
		
		
		
		System.out.println();
        System.out.println("Максимальная насыщенность матрицы составит-");
		int max=vid[0][0][0];
        for(int i = 0; i<3; i++)
        {
        	for (int j = 0; j < 9 ; j++)
        	{
        		for (int k = 0 ; k < 16 ; k++)
        		{
        			if(vid[i][j][k]>max)
	        		{
        				max = vid[i][j][k];
	        		}
        		}
        	} 
        	System.out.println("Max: "+max);
       } 
	}
}







