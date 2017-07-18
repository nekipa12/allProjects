package edu.shag.lesson11.perechislenia;

public class Player {
	private String name;
	Card aCard; //агрегирование
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Card getaCard() {
		return aCard;
	}
	public void setaCard(Card aCard) {
		this.aCard = aCard;
	}
	
	public Player(String name, Card aCard) {
		this.name = name;
		this.aCard = aCard;
	}
	
	@Override
	public String toString() {
		return "Player [name=" + name + ", aCard=" + aCard + "]";
	}
	
	
}
