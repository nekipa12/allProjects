package edu.shag.lesson11.perechislenia;

public class Card {
	
	private int value;
	
	private char symbol;
	private Suit suit;
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
		
	
	public char getSymbol() {
		return symbol;
	}
	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	public Suit getSuit() {
		return suit;
	}
	public void setSuit(Suit suit) {
		this.suit = suit;
	}
	
	public Card(int value, char symbol, Suit suit) {
		
		this.value = value;
		
		this.symbol = symbol;
		this.suit = suit;
	}
	
	@Override
	public String toString() {
		return "Card [value=" + value + "  symbol=" + symbol
				+ ", suit=" + suit + "]";
	}
	
	
	
}
