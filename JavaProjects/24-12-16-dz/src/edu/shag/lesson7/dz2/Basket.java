package edu.shag.lesson7.dz2;


import java.util.Scanner;

public class Basket 
{
	
	int count = 0;
	public static void mPhoneMtablet()
	{	
		PhoneTabletParent[] aBask = new PhoneTabletParent[9];
		while(true)
		{	
			
			System.out.println("Нажмите 1 чтобы выбрать смартфон, 2 чтобы выбрать планшет");
			System.out.println("Чтобы купить нажмите 0");
			Scanner sc = new Scanner(System.in);
			int choose = sc.nextInt();
			if(choose == 1)
			{
				mPhone(aBask);
			}
			else if(choose == 2)
			{
				mTablet(aBask);
			}else if(choose == 0) return;
			
		}
		
	}
	public static void mPhone(PhoneTabletParent[] aBask)
	{ 
		int sum=0;
		Phone[] aPhone = new Phone [5];
		aPhone[0] = new Phone("LG", 21000, 5.5, "Android", 4, 3000, 12, 8, "there is");
		aPhone[1] = new Phone("Microsoft", 19000, 5.0, "Windows", 2, 3200, 8, 4, "not");
		aPhone[2] = new Phone("Apple", 51860, 5.7, "IOS", 4, 3500, 12, 6, "there is");
		aPhone[3] = new Phone("HP", 39200, 5.5, "Windows", 4, 3100, 18, 8, "there is");
		aPhone[4] = new Phone("Xiaomi", 9480, 4.7, "Android", 1, 2500, 8, 4, "not");
		int z = 1;
		for(Phone p : aPhone)
		{
			System.out.println(z+" "+p.toString());
			z++;
		}
		method1(aPhone, aBask);
		
	}
	public static void mTablet(PhoneTabletParent[] aBask)
	{
		Tablet[] aTablet = new Tablet[4];
		aTablet[0] = new Tablet("Apple", 40000, 9.4, "IOS", 2, 6000, 12, 2, "not");
		aTablet[1] = new Tablet("CoolPad", 25000, 10.1, "Windows", 4, 4000, 5, 4, "3G");
		aTablet[2] = new Tablet("Microsoft", 33000, 12.3, "Windows", 8, 12000, 8, 4, "not");
		aTablet[3] = new Tablet("Samsung", 38000, 11.4, "Android", 4, 8000, 12, 2, "3G");
		int z =6;
		for(Tablet t : aTablet)
		{
			System.out.println(z+" "+t.toString());
			z++;
		}
		method(aTablet,aBask);	
	}
	public static void method(Tablet [] aTablet,PhoneTabletParent[] aBask)
	{
		
		while(true)
		{
			Scanner sc1 = new Scanner(System.in);
			int choose1 = sc1.nextInt();
			
			int sum=0;
			for(PhoneTabletParent z : aBask)
			{
				
				if(choose1 == 6)
				{
					aBask[5]=aTablet[0];
				}
			
				else if(choose1 == 7)
				{
					aBask[6] =aTablet[1];
				}
				else if(choose1 == 8)
				{
					aBask[7]=aTablet[2];
				}
				else if(choose1 == 9)
				{
					aBask[8]=aTablet[3];
				}
				if(choose1 == 0) return;
				System.out.println(z);
				if(z != null)
				sum+= z.getPrice();
				
			}	
			System.out.println("В корзине покупок на "+sum+ " грн");
		}
	}
	public static void method1(Phone [] aPhone,PhoneTabletParent[] aBask)
	{
		
		while(true)
		{
			Scanner sc1 = new Scanner(System.in);
			int choose1 = sc1.nextInt();
			
			int sum=0;
			
			for(PhoneTabletParent z : aBask)
			{
				if(choose1 ==1)
				{
					aBask[0]=aPhone[0];
				
				}
				else if(choose1 == 2)
				{
					aBask[1]=aPhone[1];
					
				}
				else if(choose1 ==3)
				{
					aBask[2]=aPhone[2];
					
				}
				else if(choose1 ==4)
				{
					aBask[3]=aPhone[3];
					
				}
				else if(choose1 ==5)
				{
					aBask[4]=aPhone[4];
					
				}
				if(choose1 == 0)  return;
				
				if(z != null)
				{
					sum+= z.getPrice();
					System.out.println(z);
				}
			}
			System.out.println("В корзине покупок на "+sum+ " грн");
		}
	}

}
