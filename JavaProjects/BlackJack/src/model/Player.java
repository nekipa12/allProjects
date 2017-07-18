package model;

import java.util.ArrayList;

public class Player {

	private String name;
	private int points;
	private ArrayList<Card> hand;
	private int balance;
	private int bet;

	public String getName() {
		return name;
	}
	public int getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}
	public ArrayList<Card> getHand() {
		return hand;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getBet() {
		return bet;
	}
	public Player(String name, int balance) {
		points =0;
		this.name = name;
		this.balance = balance;
		hand = new ArrayList<>();
	}
	
	public void takeCard(Croupier c, Deck d){
		
		hand.add(c.getCard(d));
	}
	public void calculate() {
		points =0;
		for( Card c : hand) {
			points += c.getPoints();
		}
		if(points > 21){
			for( Card c : hand) {
				if(c.getPictures().equals(Pictures.ACE)){
					points-=10;
				}
			}
		}
	}
	public void makeBet(int bet) {
		if(bet<0){
			bet =0;
			return;
		}
		if(balance>bet) {
			this.bet = bet;
			balance -=bet;
		} else {
			bet = balance; 
			balance = 0;
		}
	
	}
	
}
