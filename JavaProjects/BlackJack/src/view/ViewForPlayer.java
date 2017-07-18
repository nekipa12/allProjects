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
		System.out.println("������� ���� ���");
		return scLines.nextLine();
	}


	public int inputBalance() {
		System.out.println("������� ��� ������");
		return sc.nextInt();
	}
	public void o(Croupier c){
		System.out.println("��� ���������� ������ " + c.getName());
	}
	public int meMakeBets(Player p){
		System.out.println("����� " + p.getName() + ", ��� ������ " + p.getBalance());
		System.out.println("������ ���� ������!");
		return sc.nextInt();
	}
	public int askGiveMoney() {
		System.out.println("�������� �������");
		System.out.println("1 - ������� ������, 0 - ��������� ����� ������");
		return sc.nextInt();
	}
	public void moreCard(Player p){
		System.out.println(p.getName() + " �٨");
		
	}
	public int moreCardMe(Player p){
		System.out.println(p.getName()+"!  ����� �����?" + "\n"+ "1 - �����, 0 - �� �����!");
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
		System.out.println("������ ����� ��� ����������� � ����������");
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
		System.out.println("�� ��������!!!!!!!!!!");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
