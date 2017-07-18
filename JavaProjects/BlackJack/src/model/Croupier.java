package model;

import java.util.ArrayList;
import java.util.Collections;

public class Croupier {
	
	private String name;
	private int points;
	private ArrayList<Card> hand;
	private int casinoBank;

	
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
	public int getCasinoBank() {
		return casinoBank;
	}
	public void setCasinoBank(int casinoBank) {
		this.casinoBank = casinoBank;
	}
	
	
	public Croupier(String name, int casinoBank) {
		this.name = name;
		this.casinoBank = casinoBank;
		points =0;
		hand = new ArrayList<>();
	}
	
	
	public void shuffle(Deck d){
		Collections.shuffle(d.getaDeck());
	}
	
	public Card getCard(Deck d){
		Card aCard = d.getaDeck().get(0);
		d.getaDeck().remove(0);
		return aCard;
	}
	
	public void takeCard(Deck d){
		
		hand.add(getCard(d));
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

}
