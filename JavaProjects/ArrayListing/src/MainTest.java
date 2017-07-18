import java.util.ArrayList;
import java.util.Scanner;
public class MainTest {
	public static void main(String[] args) {
		ArrayList<ObJe> myBasket = new ArrayList<ObJe>();
		ObJe[] obj = new ObJe[5];
		obj[0]= new ObJe("LG", 21000, 5.5, "Android", 4, 3000, 12, 8);
		obj[1]= new ObJe("Microsoft", 19000, 5.0, "Windows", 2, 3200, 8, 4);
		obj[2]= new ObJe("Apple", 51860, 5.7, "IOS", 4, 3500, 12, 6);
		obj[3]= new ObJe("HP", 39200, 5.5, "Windows", 4, 3100, 18, 8);
		obj[4]= new ObJe("Xiaomi", 9480, 4.7, "Android", 1, 2500, 8, 4);
		int z = 1;
		for(ObJe p : obj)
		{
			System.out.println(z+" "+p.toString());
			z++;
		}
		while(true)
		{
			Scanner sc1 = new Scanner(System.in);
			int choose1 = sc1.nextInt();
			
			int sum=0;
			if(choose1 == 1)
			{
				myBasket.add(obj[0]);
			}
			else if(choose1 == 2)
			{
				myBasket.add(obj[1]);
			}
			else if(choose1 == 3)
			{
				myBasket.add(obj[2]);
			}
			else if(choose1 == 4)
			{
				myBasket.add(obj[3]);
			}
			else if(choose1 == 5)
			{
				myBasket.add(obj[4]);
			}
			else if(choose1 == 0) {
				sc1.close();
				return;
			}
			System.out.println("к-во товаров в корзине " + myBasket.size());
			System.out.println(myBasket);
			for(ObJe o : myBasket){
				sum+= o.getPrice();
			}
			System.out.println("сумма покупок на "+sum+" ЮАНЕЙ");
		}
	}
}
