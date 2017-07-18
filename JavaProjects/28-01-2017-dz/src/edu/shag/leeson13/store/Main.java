package edu.shag.leeson13.store;

import java.util.ArrayList;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
	
	public static void showTablet(Basket basket, ArrayList<PhoneTabletParent> pTP) {
		
		while(true)	{
			for(PhoneTabletParent p : pTP) {
				if (p instanceof Tablet) {
					System.out.println(p.getiD()+" "+p);
				}
			}
			System.out.println("����� ����������� �� ����� ������� 0"+"\n"+"����� ����������� �� ���� ������� 9"+"\n"
								+"����� � ������� ���� -1");
			try {		
				Scanner sc = new Scanner(System.in);
				int chooseSort = sc.nextInt();
				if(chooseSort == 0) {
					Collections.sort(pTP, new Sort().new SortByManufacturer());
					for(PhoneTabletParent p : pTP) {
						if (p instanceof Tablet) {
							System.out.println(p.getiD()+" "+p);
						}
					}
					addTablet(basket, pTP);
				}else if(chooseSort == 9) {
					Collections.sort(pTP, new Sort().new SortByPrice());
					for(PhoneTabletParent p : pTP) {
						if (p instanceof Tablet) {
							System.out.println(p.getiD()+" "+p);
						}
					}
					addTablet(basket, pTP);
				}else if(chooseSort == -1) return;
			}catch(InputMismatchException e) {
				System.out.println("������� ���������� �������� Main.showTablet().chooseSort ");
			}
		}
	}
	
	public static void showPhone(Basket basket, ArrayList<PhoneTabletParent> pTP) {
		
		
		while(true)	{
			for(PhoneTabletParent p : pTP) {
				if (p instanceof Phone) {
					System.out.println(p.getiD()+" "+p);
				}
			}
			System.out.println("����� ����������� �� ����� ������� 0"+"\t"+"����� ����������� �� ���� ������� 9"+"\n"
					+"����� � ������� ���� -1");
			try {	
				Scanner sc = new Scanner(System.in);
				int chooseSort = sc.nextInt();
				if(chooseSort == 0) {
					Collections.sort(pTP, new Sort().new SortByManufacturer());
					for(PhoneTabletParent p : pTP) {
						if (p instanceof Phone) {
							System.out.println(p.getiD()+" "+p);
						}
					}
					addPhone(basket, pTP);
				}else if(chooseSort == 9) {
					Collections.sort(pTP, new Sort().new SortByPrice());
					
					for(PhoneTabletParent p : pTP) {
						if (p instanceof Phone) {
							System.out.println(p.getiD()+" "+p);
						}
					}
					addPhone(basket, pTP);
				}else if(chooseSort == -1) return;
			}catch(InputMismatchException e) {
				System.out.println("������� ���������� �������� Main.showPhone().chooseSort ");
			}
		}
	}
	
	public static void addPhone(Basket basket, ArrayList<PhoneTabletParent> pTP){
		System.out.println("����� �������� ����� � ������� ������� iD ������"+"\n"+"��� ������ ������� -1");
		while(true) {
			try {	
				Scanner sc = new Scanner(System.in);
				int chooseVar = sc.nextInt();
				for(PhoneTabletParent p : pTP) {
					if (p instanceof Phone) {
						if(chooseVar == p.getiD()) {
							basket.addDevice(p);
						}else if(chooseVar == -1) return;
					}
				}
			}catch(InputMismatchException e) {
				System.out.println("������� ���������� �������� main addPhone().chooseVar");
			}
		}
	}
	public static void addTablet(Basket basket, ArrayList<PhoneTabletParent> pTP){
		System.out.println("����� �������� ����� � ������� ������� iD ������"+"\n"+"��� ������ ������� -1");
		while(true) {
			try {
				Scanner sc = new Scanner(System.in);
				int chooseVar = sc.nextInt();
				for(PhoneTabletParent p : pTP) {
					if (p instanceof Tablet) {
						if(chooseVar == p.getiD()) {
							basket.addDevice(p);
						}else if(chooseVar == -1) {
							
							return;
						}
							
					}
				}
			}catch(InputMismatchException e) {
				System.out.println("������� ���������� �������� main addTablet().chooseVar");
			}
		}
		
	}
	public static void editBasket(Basket basket) {
		while(true){
			try {
				Scanner sc = new Scanner(System.in);
				//ListIterator<PhoneTabletParent> it = basket.getBsc().listIterator();
				int sum = 0;
				for(PhoneTabletParent b : basket.getBsc()) {
					System.out.println(b);
					sum+=b.getPrice();
				}
				System.out.println("� k������ ������� �� "+sum);
				System.out.println("��� ������� ������� 1"+"\n"+"��� �������������� ������� ������� 0"+"\n"+
									" ��� ������ � �������  ���� ������� -1!!! ");
		
				int chooseDelete= sc.nextInt();
				if(chooseDelete == 1) basket.buy(basket);
				else if(chooseDelete == 0) basket.deleteDevice(basket);
				else if(chooseDelete == -1){
					
					return;
				}
			}catch(InputMismatchException e) {
				System.out.println("������� ���������� �������� main chooseDelete");
			}
		}	
	}
	
	public static void main(String[] args) {
		Basket basket = new Basket();
		ArrayList<PhoneTabletParent> pTP = new ArrayList<>();
		pTP.add(new Tablet("Apple", 40000, 9.4, "IOS", 2, 6000, 12, 2, 1, "not"));
		pTP.add(new Tablet("CoolPad", 25000, 10.1, "Windows", 4, 4000, 5, 4,2, "3G"));
		pTP.add(new Tablet("Microsoft", 33000, 12.3, "Windows", 8, 12000, 8, 4,3, "not"));
		pTP.add(new Tablet("Bravis", 38000, 11.4, "Android", 4, 8000, 12, 2, 4, "3G"));
		pTP.add(new Phone("LG", 21000, 5.5, "Android", 4, 3000, 12, 8, 1, "there is"));
		pTP.add(new Phone("Microsoft", 19000, 5.0, "Windows", 2, 3200, 8, 4, 2, "not"));
		pTP.add(new Phone("Apple", 51860, 5.7, "IOS", 4, 3500, 12, 6, 3, "there is"));
		pTP.add(new Phone("HP", 39200, 5.5, "Windows", 4, 3100, 18, 8, 4, "there is"));
		pTP.add(new Phone("Xiaomi", 9480, 4.7, "Android", 1, 2500, 8, 4, 5,"not"));
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("������� 1 ����� ������� ��������"+"\n"+"������� 2 ����� ������� ��������"+
								"\n" + "0 ����� ����� � �������"+
								"\n" + "-1 ����� �������� �������");
			int choosePT = sc.nextInt();
			if(choosePT == 1) {
				showTablet(basket, pTP);
			} else if(choosePT ==2){
				showPhone(basket, pTP);
			}else if(choosePT == 0) {
				editBasket(basket);
			}else if(choosePT == -1){
				sc.close();
				return;
			}
		}
		
	}

	
}
