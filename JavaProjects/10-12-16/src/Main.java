
public class Main 
{

	
	
	
	
	/*static void biggerOfTwo(int a, int b)
	{
		if (a>b)System.out.println(a+" is bigger than " + b);
		else System.out.println(b +  " is bigger than " +a);
	}*/
	
	
	/*public static void main(String[] args)
	{
			biggerOfTwo(5,7);
			int first = 1, second=-50;
			biggerOfTwo(first,second);

	}*/

	
	
	
	
	
	
	
	
	
	
	/*static double biggerOfTwo (double a, double b)
	{
		if (a>b) return a;
		else return b;
	}	
	
	

	public static void main(String[] args)
	{
		
		double first = 5.5, second=7.7775;
		double result = biggerOfTwo(first,second);
		System.out.println(result);//7.7775
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*static double getAvg (double[] arr)
	{
		double sum = 0;
		for (int i=0; i<arr.length; i++)
		{
			sum+=arr[i];
		}
		return sum/arr.length;
	}
	
	public static void main(String[] args)
	{
		
		double [] mas = new double[]{1.1,2.2,3.3,4.4,5.5};
		double  avg = getAvg(mas);
		System.out.println(avg);
	}*/
	
	
	
	
	
	
	
	
	
	
	
	/*//сумма элементов в каком массиве больше
	static double[] getAvg (double[] arr, double [] arr1)
	{
		double sum = 0, sum1 = 0;
		for (int i=0; i<arr.length; i++)
		{
			sum+=arr[i];
		}
		for (int i=0; i<arr1.length; i++)
		{
			sum1+=arr1[i];
		}
		if (sum>sum1) return arr;
		return arr1;
	}
	
	public static void main(String[] args)
	{
		
		double [] mas = new double[]{1.1,2.2,3.3,4.4,5.5};
		double [] mas1 = new double[]{1.1,0.2,3.3,5.4,5.5};
		double [] res = getAvg ( mas, mas1);
		
		for (int i=0; i<res.length; i++)
		{
			System.out.println(res[i] + "\t");
		}
	}*/	
		
	
	
	
	
	
	
	
	
	
	//перегрузка функций "оверлоад" прием при котором создаютс€ 
	//функции с одинаковыми названи€ми
	// но разными параметрами и типом возвращаемого значени€
	/*static int biggerOfTwo (int a, int b)
	{
		if (a>b) return a;
		else return b;
	}	
	//static int biggerOfTwo (double a, double b)
	//{
		//if (a>b) return a;
		//else return b;
	//}
	public static void main(String[] args)
	{
		
		double first = 5.5, second=7.7775;
		int c=1, d=2;
		
		System.out.println(biggerOfTwo(first,second));//7.7775
		System.out.println(biggerOfTwo(c,d));
		
	}*/
	
	
	
	
	
	
	
	/*static void func(int[] arr, double d)
	{
		d++;
		arr[0]=-555;
		arr = new int[]{4,5,6,};
	}
	
	public static void main(String[] args)
	{
		double d = 1.0;
		int []arr =new int []{1,2,3};
		func(arr,d);
		System.out.println(arr[0]);
		System.out.println(d);
	}*/
	

	
	
	
	
	




//шаблонна€ функци€
	/*static <T> void method (T[] a)
	{
		for (int i=0; i<a.length; i++)
		{
			
			System.out.println(a[i]);
		}
	}

	
	public static void main(String[] args)
	{
		Integer[] arr = new Integer[]{1,2};
		method(arr);
		///int[] arr2 = new int[]{1,2};
		//method(arr2);
		//double[] arr3 = new double[]{1.5,2.5};
		//method(arr3);
	}*/
	
	
	





				//–≈ ”–—»я

	/*static String numbers (int n)
	{
		if (n ==1) return "1";
		return numbers (n-1) + " " + n;
	}

	public static void main(String[] args)
	{
		System.out.println(numbers(5));
	}*/
	
	
	
	
				//–≈ ”–—»я
	
	/*static String recursion (int a, int b)
	{
		if (a ==b) return String.valueOf(b);
		return a + " " + recursion(a+1,b);
	}

	public static void main(String[] args)
	{
		System.out.println(recursion(1,10));
	}*/

	
	
	
	
	
	
	
	
	/*//деление по модулю...
	static int summ (int n)
	{
		if (n <10) return n;
		return n%10+summ(n/10);
	}

	public static void main(String[] args)
	{
		System.out.println(summ(125));
	}*/
	
	
	
	
	
	
	
	
	
	
	/*//число в обратном пор€дке
	
	static int write (int n)
	{
		if (n <10) return n;
		
	System.out.print(n%10 + " ");
	return write(n/10);
	}

	public static void main(String[] args)
	{
		System.out.print(write(125));
	}*/
	
	
	
	
	
	
	
	
	
	
	
	//возводит в степень
	//1-число
	//2-степень
	/*static int pow (int x, int y)
	{
		if (y == 1) return x;
		return x*pow(x,y-1);
	
	}

	public static void main(String[] args)
	{
		System.out.print(pow(2,9));
	}*/
	
	







}



