
public class Modul_2 {

	public static void main(String[] args) 
	{ 
		int counter = 0; 
		for(int gallons = 1; gallons <= 100; gallons ++)
		{ 
			double liters = gallons * 3.7854;
			System.out.println(gallons + " gallons is " + liters + " liters." ); 
			counter ++; 
			if (counter == 10) 
			{ 
				System.out.println(); 
				counter = 0; 
			} 
		} 
	} 

}
