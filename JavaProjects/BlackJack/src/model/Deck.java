package model;

import java.util.ArrayList;

public class Deck {
	
	private ArrayList<Card> aDeck;
	private int poi;
	
	public int getPoi() {
		return poi;
	}
	public void setPoi(int poi) {
		this.poi = poi;
	}
	public ArrayList<Card> getaDeck() {
		return aDeck;
	}
	public Deck() {
		aDeck = new ArrayList<>(52); 
		
		for(Suit s : Suit.values()){
			for( Pictures p : Pictures.values()){
				poi = p.getPoints(); 
				Card aCard = new Card (s, p, poi );
				aDeck.add(aCard);
			}
		}
	}
}
