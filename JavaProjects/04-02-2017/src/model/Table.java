package model;

import java.util.ArrayList;

public class Table {

	private ArrayList<Player> players;
	private int bank;
	
	public Table(){
		players = new ArrayList<>();
		bank = 0;
	}
	public void addPlayer(int nBones, int balance, String name) {
		
		players.add(new Player(nBones, balance, name));
	}
	
	public int getBank() {
		return bank;
	}
	public void setBank(int bank) {
		this.bank = bank;
	}
	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	
	
}
