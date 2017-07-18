package model;

import java.util.ArrayList;
import java.util.Random;

public class Table {

	private ArrayList<Player> players;
	private Croupier croupier;
	private Deck aDeck;
	private Player player;

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Deck getaDeck() {
		return aDeck;
	}
	
	public void setaDeck(Deck aDeck) {
		this.aDeck = aDeck;
	}

	public Croupier getCroupier() {
		return croupier;
	}
	
	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	public Table() {
		players = new ArrayList<>();
		aDeck = new Deck();
		
	}
	
	public void addMeImPlayer(String name, int balance){
		player = new Player(name, balance);
	}
	public void addMePlease(String name, int balance){
		croupier = new Croupier(name, balance);
	}
	public void addPlayer(String name, int balance){
		players.add(new Player(name, balance));
	}
	
	public void removeLoosers(){
		for (int i = 0; i < players.size(); i++){
			if(players.get(i).getBalance() <=100){
				System.out.println("у игрока слишком мало денег для ставки,  игрок" + players.get(i).getName()+ " удалён");
				players.remove(i);
			}
		}
	}
	
	public void outOfGame(){
		Random rnd = new Random();
		for (int i = 0; i < players.size(); i++){
			int a = rnd.nextInt(15);
			if(a == 1){
				System.out.println("игрок уходит " + players.get(i).getName());
				players.remove(i);
			}
		}
	}
}
