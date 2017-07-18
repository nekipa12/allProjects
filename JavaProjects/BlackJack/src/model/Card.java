package model;

public class Card {
	private Suit suit;
	private Pictures pictures;
	private int points;
	public Suit getSuit() {
		return suit;
	}
	public void setSuit(Suit suit) {
		this.suit = suit;
	}
	public Pictures getPictures() {
		return pictures;
	}
	public void setPictures(Pictures pictures) {
		this.pictures = pictures;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public Card(Suit suit, Pictures pictures, int points) {
		this.suit = suit;
		this.pictures = pictures;
		this.points = points;
	}
	@Override
	public String toString() {
		return "Card [suit=" + suit + ", pictures=" + pictures + ", points="
				+ points + "]";
	}
	
}
