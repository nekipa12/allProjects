package view;


import java.util.Random;
import java.util.Scanner;

import model.Card;
import model.Croupier;
import model.Deck;
import model.Player;

public class ViewForCroupier {
	
	private Random rnd;
	private String [] names;
	private Scanner sc;
	private Scanner scLines;
	private CardView cv;
	
	public ViewForCroupier() {
		rnd = new Random();
		sc = new Scanner(System.in);
		scLines = new Scanner(System.in);
		cv = new CardView();
	}
	public void autoSave(){
		System.out.println("��������������...");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}
	public String methYn(){
		System.out.println("����� ��������� ���� ������� 'y',"+"\n"
							+" ����� ���������� ������� ����� ������ ");
		return scLines.nextLine();
	}
	public void push(Player p, Croupier c){
		System.out.println("��� " + "����� - " + p.getName()+", ���� - "+ p.getPoints()
							+ " ������ - " + c.getName() +", ���� - " + c.getPoints());
	}
	public String inputName(){
		System.out.println("������, ������� ��� ���! ");
		return scLines.nextLine();
	}
	public int moreCardMe(Croupier c){
		System.out.println(c.getName()+"!  ����� �����?" + "\n"+ "1 - �����, 0 - �� �����!");
		if(sc.hasNextInt()) {
			System.out.println();
			return sc.nextInt();
		}else return 20000000;
	}
	public int moreCard(Player p){
		System.out.println(p.getName() + " �٨");
		if(sc.hasNextInt()) 
			return sc.nextInt();
		return 2;
	}
	public int chooseNumPlayers(){
		return rnd.nextInt(5);
	}
	public String chooseName(){
		names = new String []{"Petter", "Billy", "Donald", "Avraam", "Holly", "Robin", "Issi", "James", "Oliver", "Abraham", "Range",
								"Lindy", "Popper", "Goover", "Stinci", "Jhonatan", "Lois", "Bart", "Barbara"};
		int f = rnd.nextInt(names.length);
		return names[f];
	}
	public int chooseBalance(){
		return rnd.nextInt(5000);
	}
	
	public  void showPlayer(Player p) {
		System.out.println("����� ����� "+p.getName());
	}
	
	public int makeBet(Player p){
		System.out.println("����� " + p.getName() + " , ��� ������ - " + p.getBalance() + ". ������� ������!");
		int mb = 1 + (int)(Math.random()*((p.getBalance() - 1) + 1));
		return mb;
	}
	
	public void accepted(Player p){
		System.out.println("���� ������ " + p.getBet() + " �������!");
	}
	
	public void showWinnerPlayer(Player p, Croupier c) {
		System.out.println("���������� �����" + p.getName()+", ���� - "+ p.getPoints()
							+ " ������ - " + c.getName() +", ���� - " + c.getPoints());
	}
	
	public void showWinnerCroupier(Croupier c, Player p) {
		System.out.println("���������� ������" + c.getName()+", ���� - "+ c.getPoints()
		+ " ����� - " + p.getName() +", ���� - " + p.getPoints());
	}
	
	public void blackJack(Player p) {
		System.out.println("� ������ " + p.getName() + "BLACKJACK!!!!!!!!!!");
	}
	
	public int askGiveMoney() {
		return rnd.nextInt(5);
	}
	
	public void gameOver(Player p) {
		System.out.println(p.getName()+" ������� " + " ���� -" + p.getPoints());
	}
	
	public void showMyPoints(Croupier c) {
		System.out.println("���� ������ "+c.getPoints());
	}
	
	public void showMyCards(Croupier c) {
		System.out.println("_____________________________����");
		for(Card b : c.getHand()){
			
			cv.meth(b);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	public int annigilation() {
		System.out.println("����� �������������� ������� - 1, ����� ���������� - ����� ������ ");
		if(sc.hasNextInt()) {
			return sc.nextInt();
		}
		else return 20000000;
		
	}
	public void pause() {
		System.out.println("����������� ������");
		
	}

	public void showPlayersCard(Player p) {
		System.out.println("����� ������ " + p.getName());
		for(Card b : p.getHand()){
			cv.meth(b);
			
		}
		
	}
	public void showPlayersBackCard(Player p) {
		System.out.println("������� ������ " + p.getName());
		for(Card b : p.getHand()){
			cv.shirt();
			
		}
		
	}
	public void showPlayersBack(Player p) {
		System.out.println("������� ������ " + p.getName());
			cv.shirt();
		
	}
	public void showCroupierBackCard(Croupier c) {
		cv.shirt();
	}
	public void takeMoney(Player p) {
		System.out.println("����� " + p.getName() + "�������� ������");
		cv.shirt();
			
		
		
	}
}
