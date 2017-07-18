package edu.shag.lesson11.oop;

public class Player extends Human{
	
	private int numOfGamesWon;
	private int numOfGamesLost;
	
	public int getNumOfGamesWon() {
		return numOfGamesWon;
	}
	public void setNumOfGamesWon(int numOfGamesWon) {
		this.numOfGamesWon = numOfGamesWon;
	}
	public int getNumOfGamesLost() {
		return numOfGamesLost;
	}
	public void setNumOfGamesLost(int numOfGamesLost) {
		this.numOfGamesLost = numOfGamesLost;
	}
	
	public Player(String name, int age, int skill, int numOfGamesWon,
			int numOfGamesLost) {
		super(name, age, skill);
		this.numOfGamesWon = numOfGamesWon;
		this.numOfGamesLost = numOfGamesLost;
	}
	
	@Override
	
	public String toString() {

		return "Player"+super.toString()+" [numOfGamesWon=" + numOfGamesWon + ", numOfGamesLost="
				+ numOfGamesLost + "]";
	}
	
	@Override
	public void play() {
		System.out.println("Удар игрока" + getName());
		
	}
	
	

}
