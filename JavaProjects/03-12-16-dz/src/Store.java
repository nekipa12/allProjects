import java.util.Arrays;


public class Store 
{
	public static void main(String[] args) 
	{
		String[] laptops = {"MSI", "Lenovo", "Apple", "HP", "Acer", "Dell"};
		int [] price = {44560, 8900, 94999, 23450, 19200, 21000};
		int i, laptops1 = laptops.length;
		for ( i=0; i<laptops1; i++)
		{
			laptops[i]+="\t"+price[i];
		}
		System.out.println();
		Arrays.sort(laptops);
		for ( i=0; i<laptops1; i++)
		{
			System.out.println(laptops[i]);
		}
	}	
}	


