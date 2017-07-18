import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Array 
{
	
	
	public static void main(String[] args)
	{
		
		//int [] arr = new int[5];
		//arr[0]= 100;
		//arr[4]= -7;
		//System.out.println(arr);
		
		//for (int i=0; i<arr.length; i++)
		//System.out.print(arr[i]+"\t");
		
		/*int N;
		Scanner sc = new Scanner (System.in);
		N = sc.nextInt();
		double[] arr2 = new double[N];
		for (int i=0; i<arr2.length; i++)
		{
			System.out.println("Введите число");
			arr2[i] = sc.nextDouble();
		}
		
		for (int i=0; i<arr2.length; i++)
		{
			arr2[i]++;
			System.out.println(arr2[i]);
		}*/
		
		
		
		/*Scanner sc = new Scanner (System.in);	
		int[] arr1 = new int[]{1, 2, 3, -5};
		int[] arr2 = new int[4];
		arr2[0] = 1;
		arr2[1] = 2;
		arr2[2] = 3;
		arr2[3] =sc.nextInt();
		
		//for (int i=0; i<arr1.length; i++)
		//{
			//if (arr1[i] != arr2[i]) {System.out.println("Not equal"); return;}
			//if (arr1==arr2) System.out.println("equal");
		//}
		//System.out.println("Equal");

		//if (arr1==arr2) System.out.println("equal");
	
		//if (arr1.equals(arr2)) System.out.println("equal");
	
		//if(Arrays.equals(arr1, arr2)) System.out.println("equal");*/
	
		
		
		/*int N;
		Scanner sc = new Scanner (System.in);
		N = sc.nextInt();
		double[] arr2 = new double[N];
		for (int i=0; i<arr2.length; i++)
		{
			System.out.println("Введите число");
			arr2[i] = sc.nextDouble();
		}
		
		//double	sum = 0;
		//for (int i=0; i<arr2.length; i++)
		//{
		//	sum+=arr2[i];
		
		//}
		//System.out.println(sum);
	//double avg = sum/arr2.length;
	//System.out.println(avg);
	
	
	
	//double min = arr2[0], max = arr2[0];
	//int nMin = 0, nMax = 0;
	
	//for (int i=1; i<arr2.length; i++)
	//{
		//if (arr2 [i]<min) {min = arr2[i]; nMin=i;}
		//if (arr2 [i]>max) {max = arr2[i]; nMax=i;}
	//}
	//System.out.println("mai = "+ min + "\nmax = " + max);
	
	
	/*System.out.println("Vvedite");
	int x = sc.nextInt();
	for (int i=0; i<arr2.length; i++)
	{
		if (arr2 [i]==x)
		{
			System.out.println(" ego nomer " + i);
		break;
		}
	
	}*/
		
		
		
		
		/*Random rnd = new Random();
		int r = rnd.nextInt(20);     //0...19
		double rd = rnd.nextDouble();	//0.....1
		double rz = r + rd;
		
		
		int randN = 1 + rnd.nextInt(10);
		int[] arr3 = new int [randN];
		for (int i=0; i<arr3.length; i++)
		{
			arr3 [i] = rnd.nextInt(101);
			System.out.print(arr3[i] + "\t");
		}*/
		
		/*Scanner sc = new Scanner (System.in);
		int N;// seconds
		int f;// chastota
		System.out.println("input nSeconds");
		N = sc.nextInt();
		System.out.println("chastota");
		f = sc.nextInt();
		Random rnd = new Random();
		Object sound = new int [N*f];
		for (int i=0; i<sound.length; i++)
		{
			
			sound = rnd.nextInt(256);
		}*/

		
		
		Random rnd = new Random();

		int[][] picture = new int[3][]; // 3x4 строчки
		for (int i = 0; i < picture.length; i++) 
		{
			picture[i] = new int[i + 1]; // столбцы
		}

		for (int i = 0; i < picture.length; i++)// цикл по строкам
		{
			for (int j = 0; j < picture[i].length; j++)// по столбцам
			{
				picture[i][j] = rnd.nextInt(256);
				System.out.print(picture[i][j] + "\t");
			}
		}

		int sum;
		for (int i = 0; i < picture.length; i++)// цикл по строкам
		{
			sum = 0;
			for (int j = 0; j < picture[i].length; j++)// по столбцам
			{
				sum += picture[i][j];
			}
			System.out.println(sum);
		}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
}
