package controller;



import view.View;
import model.Player;
import model.Table;

public class Game {
	
	private Table aTable;
	private View aView;
	private int numPlayers;
	//поля которые управляют правилами игры!
	
	public Game(){
		aView = new View();
		aTable = new Table();
	}
	
	public void start(){
		numPlayers = aView.askNumPlayers();
		for(int i = 0; i<numPlayers; i++){
			String name = aView.inputName();
			int balance = aView.inputBalance();
			int NumDice = aView.inputNBones();
			aTable.addPlayer(numPlayers, balance, name);
		}
		do{
			play();
		}while(aView.playAgain());
		
	}
	
	public void play(){
		makeBets();
		rollDice();
		checkWinner();
	}

	

	public void makeBets(){
		for(Player p : aTable.getPlayers()){
			int bet = aView.makeBet(p);
			p.makeBet(bet);
		}
	}
	
	private void rollDice() {
		for(Player p : aTable.getPlayers()){
			aView.askToRoll(p);
			p.roll();
		}
		
	}

	private void checkWinner() {
		int winnerNum = 0, winnerPoints = 0;
		for (int i = 0; i< aTable.getPlayers().size(); i++) {
			if(aTable.getPlayers().get(i).getPoints()>winnerPoints){
				winnerNum =i;
				winnerPoints = aTable.getPlayers().get(i).getPoints();
			}
		}
		aTable.getPlayers().get(winnerNum).givePrize();
		aView.showWinner(aTable.getPlayers().get(winnerNum));
		winnerNum++;
		if(winnerNum < aTable.getPlayers().size()) {
			for (int i = winnerNum; i< aTable.getPlayers().size(); i++){
				if(aTable.getPlayers().get(i).getPoints() == winnerPoints){
					aTable.getPlayers().get(i).givePrize();
					aView.showWinner(aTable.getPlayers().get(winnerNum));
				}
			}
		}
		
		
	}
	
}
