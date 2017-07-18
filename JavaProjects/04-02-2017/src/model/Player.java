package model;

import java.util.Arrays;

public class Player {

	private String name;
	private int balance;
	private int bet;
	private Bone [] bones;
	private int points;
	
	public Player (int nBones, int balance, String name){
		bones = new Bone[nBones];
		for(int i = 0; i<nBones; i++){
			bones[i] = new Bone();
		}
		this.balance = balance;
		this.name = name;
		bet = 0;
		points = 0;
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

	public void setBet(int bet) {
		this.bet = bet;
	}

	public String getName() {
		return name;
	}

	public Bone[] getBones() {
		return bones;
	}

	public int getPoints() {
		return points;
	}
	
	public void roll(){
		
		for(int i = 0; i<bones.length; i++){
			bones[i].drop();
		}
		calculatePoints();
	}

	private void calculatePoints() {
		
		points = 0;
		for(int i = 0; i<bones.length; i++){
			points +=bones[i].getPoints();
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

	@Override
	public String toString() {
		return "Player [name=" + name + ", balance=" + balance + ", bet=" + bet
				+ ", bones=" + Arrays.toString(bones) + ", points=" + points
				+ "]";
	}
	public void givePrize(){
		balance += bet*3;
	}
	
}