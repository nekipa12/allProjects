package edu.shag.lesson11.oop;

public class Referee extends Human {
	
	private int numOfGames;

	public int getNumOfGames() {
		return numOfGames;
	}
	public void setNumOfGames(int numOfGames) {
		this.numOfGames = numOfGames;
	}

	
	public Referee(String name, int age, int skill, int numOfGames) {
		super(name, age, skill);
		this.numOfGames = numOfGames;
	}

	
	@Override
	public String toString() {
		return "Referee"+super.toString()+" [numOfGames=" + numOfGames + "]";
	}

	@Override
	public void play() {
		
		System.out.println("Решение арбитра" + getName());
	}
	
	

}
