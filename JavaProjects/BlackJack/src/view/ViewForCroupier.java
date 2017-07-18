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
		System.out.println("АВТОСОХРАНЕНИЕ...");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}
	public String methYn(){
		System.out.println("Чтобы загрузить игру нажмите 'y',"+"\n"
							+" чтобы продолжить нажмите любую кнопку ");
		return scLines.nextLine();
	}
	public void push(Player p, Croupier c){
		System.out.println("ПУШ " + "игрок - " + p.getName()+", очки - "+ p.getPoints()
							+ " крупье - " + c.getName() +", очки - " + c.getPoints());
	}
	public String inputName(){
		System.out.println("Крупье, введите своё имя! ");
		return scLines.nextLine();
	}
	public int moreCardMe(Croupier c){
		System.out.println(c.getName()+"!  взять карту?" + "\n"+ "1 - взять, 0 - не брать!");
		if(sc.hasNextInt()) {
			System.out.println();
			return sc.nextInt();
		}else return 20000000;
	}
	public int moreCard(Player p){
		System.out.println(p.getName() + " ЕЩЁ");
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
		System.out.println("Новый игрок "+p.getName());
	}
	
	public int makeBet(Player p){
		System.out.println("Игрок " + p.getName() + " , ваш баланс - " + p.getBalance() + ". Делайте ставку!");
		int mb = 1 + (int)(Math.random()*((p.getBalance() - 1) + 1));
		return mb;
	}
	
	public void accepted(Player p){
		System.out.println("Ваша ставка " + p.getBet() + " принята!");
	}
	
	public void showWinnerPlayer(Player p, Croupier c) {
		System.out.println("Выигрывает игрок" + p.getName()+", очки - "+ p.getPoints()
							+ " крупье - " + c.getName() +", очки - " + c.getPoints());
	}
	
	public void showWinnerCroupier(Croupier c, Player p) {
		System.out.println("Выигрывает крупье" + c.getName()+", очки - "+ c.getPoints()
		+ " игрок - " + p.getName() +", очки - " + p.getPoints());
	}
	
	public void blackJack(Player p) {
		System.out.println("У игрока " + p.getName() + "BLACKJACK!!!!!!!!!!");
	}
	
	public int askGiveMoney() {
		return rnd.nextInt(5);
	}
	
	public void gameOver(Player p) {
		System.out.println(p.getName()+" ПЕРЕБОР " + " очки -" + p.getPoints());
	}
	
	public void showMyPoints(Croupier c) {
		System.out.println("Очки крупье "+c.getPoints());
	}
	
	public void showMyCards(Croupier c) {
		System.out.println("_____________________________СЕБЕ");
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
		System.out.println("Чтобы АННИГИЛИРОВАТЬ нажмите - 1, чтобы пропустить - любую кнопку ");
		if(sc.hasNextInt()) {
			return sc.nextInt();
		}
		else return 20000000;
		
	}
	public void pause() {
		System.out.println("ТЕХНИЧЕСКИЙ ПРЕРЫВ");
		
	}

	public void showPlayersCard(Player p) {
		System.out.println("Карты игрока " + p.getName());
		for(Card b : p.getHand()){
			cv.meth(b);
			
		}
		
	}
	public void showPlayersBackCard(Player p) {
		System.out.println("Раздача игроку " + p.getName());
		for(Card b : p.getHand()){
			cv.shirt();
			
		}
		
	}
	public void showPlayersBack(Player p) {
		System.out.println("Раздача игроку " + p.getName());
			cv.shirt();
		
	}
	public void showCroupierBackCard(Croupier c) {
		cv.shirt();
	}
	public void takeMoney(Player p) {
		System.out.println("ИГРОК " + p.getName() + "ЗАБИРАЕТ СТАВКУ");
		cv.shirt();
			
		
		
	}
}
