
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;



public class Methods 
{
	
	
	/*static void foobar(int[][] a, double r,int c )
	{
		if(c==3)return;
		int y=0;
		Random rnd = new Random();
		int sum=0;
		for(int i=0; i<a.length; i++)
		{
			for(int j=0; j<a[i].length; j++)
			{
				a[i][j]=rnd.nextInt(256);
				a[i][j]*=r;
				if(a[i][j]>256)
				{	
					a[i][j]=256;
				}
				System.out.print(a[i][j]+"\t");
				sum +=a[i][j];
				y=(a.length*a[i].length);
			
			//System.out.print(y);
			}
			System.out.println();	
		}	
		System.out.println();
		System.out.print("среднее "+sum/y);
		
		
		int max=a[0][0];
	    for(int i = 0; i<a.length; i++)
	    {
	    	for (int j = 0; j < a[i].length ; j++)
	        {
	        	if(a[i][j]>max)
		        {
	        		max = a[i][j];
		        }
	        } 
	     } 
	     System.out.println(" Max: "+max);
	     System.out.println();
	     c++;	
	     foobar(a,r, c); 
	}	
		
	public static void main(String[] args)
	{
		int c1=0;
		double c =1.05; 
		int [][] go= new int[9][16];
		foobar(go, c, c1);
	}*/
	
	
	
	/*static void strIng (String[] w, String[] w1)
	{
		int f= 0;
		for (int i=0; i<w.length; i++)
		{
			for(int j=0; j<w1.length; j++)
			{
				if(w[i].equalsIgnoreCase(w1[j]))
				{
					f++;
				}
			}
		}
	System.out.println(f);
	}
	
	public static void main(String[] args) 
	{
		String s = "мама мыла раму автмобиля марки Заз, Газ";
		String s1 =  "Мама мыла раму автомобиля марки ЗаЗ, КаМАЗ, КрАЗ";
		String[] words = s.split(" "); 
		String[] words1 = s1.split(" "); 
		strIng(words, words1);
	}*/
		
		
		
		
	/*static void func1(int[] arr, Integer[] arr1)
	{
		Arrays.sort(arr);
		for (int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
		System.out.println();
		Arrays.sort(arr1, Collections.reverseOrder());
		for (Integer i=0;i<arr1.length;i++)
		{
			System.out.println(arr1[i]);
		}
	}
	
	public static void main(String[] args) 
	{
		int[] arr2 = new int[]{9,8,7,6,5,4,3,2,1,10,15,16,18};
		Integer[] arr3 = new Integer[]{1,2,3,40,58,66,77,28,19,50,10,15,16,18};
		func1(arr2, arr3);
	}*/
	
	
	
	
	static int[] func()
	{
		Random rnd = new Random();
		int []arr= new  int [rnd.nextInt(10)];	
		for (int i = 0; i<arr.length; i++)
	    {
			arr[i] = rnd.nextInt(1000);				
		}
		return arr;
	
	}
	
	public static void main(String[] args) 
	{
		
		int[]array= func();
		for (int i = 0; i<array.length; i++)
	    {
			System.out.println(array[i]);
	    }
	}	
	
	
	
		
		
		
	

}
