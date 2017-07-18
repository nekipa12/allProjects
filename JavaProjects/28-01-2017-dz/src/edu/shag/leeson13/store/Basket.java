package edu.shag.leeson13.store;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Basket {
	private LinkedList<PhoneTabletParent> bsc;
	public LinkedList<PhoneTabletParent> getBsc() {
		return bsc;
	}
	public Basket() {
		bsc = new LinkedList<>();
	}
	public void addDevice(PhoneTabletParent p) {
		bsc.add(p);
		System.out.println("Добавлено в корзину");
	}
	public void deleteDevice(Basket basket) {
		System.out.println("Введите iD для удаления товара из корзины"+"\n"+"-1 чтобы завершить редактирование!");
		while(true) {
			int i =0;
			
			for(PhoneTabletParent b : basket.getBsc()) {
				System.out.println(i+" "+b);
				i++;
			} 
			try{
				Scanner sc = new Scanner(System.in);
				int delete = sc.nextInt();
				if(delete == -1) return;
				bsc.remove(delete);
			}catch(InputMismatchException e) {
				System.out.println("Введите корректное значение Basket");
			}catch(IndexOutOfBoundsException e) {
				System.out.println("Корзина пуста!");
			}
		}
	}
	public void buy(Basket basket) {
		bsc.clear();
	}
}
