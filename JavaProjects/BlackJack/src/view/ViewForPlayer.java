package view;

import java.util.Random;
import java.util.Scanner;

import model.Croupier;
import model.Player;

public class ViewForPlayer {
	private Random rnd;
	private String [] names;
	private Scanner sc;
	private Scanner scLines;
	private CardView cv;
	public ViewForPlayer() {
		rnd = new Random();
		sc = new Scanner(System.in);
		scLines = new Scanner(System.in);
		cv = new CardView();
	}
	
	
	public String inputName() {
		System.out.println("Введите ваше имя");
		return scLines.nextLine();
	}


	public int inputBalance() {
		System.out.println("Введите ваш баланс");
		return sc.nextInt();
	}
	public void o(Croupier c){
		System.out.println("Вас обсуживает крупье " + c.getName());
	}
	public int meMakeBets(Player p){
		System.out.println("Игрок " + p.getName() + ", ваш баланс " + p.getBalance());
		System.out.println("Деайте вашу ставку!");
		return sc.nextInt();
	}
	public int askGiveMoney() {
		System.out.println("Выберите вариант");
		System.out.println("1 - забрать деньги, 0 - дождаться конца партии");
		return sc.nextInt();
	}
	public void moreCard(Player p){
		System.out.println(p.getName() + " ЕЩЁ");
		
	}
	public int moreCardMe(Player p){
		System.out.println(p.getName()+"!  взять карту?" + "\n"+ "1 - взять, 0 - не брать!");
		if(sc.hasNextInt()) {
			System.out.println();
			return sc.nextInt();
		}else return 20000000;
	}
	public void warning(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("КРУПЬЕ НАЧАЛ ВАС ПОДОЗРЕВАТЬ В МАХИНАЦИЯХ");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void warningLooser(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ВЫ ПОПАЛИСЬ!!!!!!!!!!");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
