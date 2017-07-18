package controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import com.google.gson.Gson;
import model.Player;
import model.Table;
import view.Intro;
import view.ViewForCroupier;

public class CroupierGameplay {
	
	private ViewForCroupier aView;
	private Table aTable;
	private int numPlayers;
	private Intro intro;

	public CroupierGameplay(){
		aView = new ViewForCroupier();
		aTable = new Table();
		intro = new Intro();
	}
	void methAddMe(){
		String name = aView.inputName();
		aTable.addMePlease(name, 25000);
	}
	void methAddPlayers(){
		String name;
		int balance;
		while(numPlayers == 0){
			numPlayers = aView.chooseNumPlayers();
		}
		for(int i = 0; i<numPlayers; i++){
			name = aView.chooseName();
			balance = aView.chooseBalance();
			aTable.addPlayer(name, balance);
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			aView.showPlayer(aTable.getPlayers().get(i));
		}
	}
	public void start(){
		intro.intro();
		if(aView.methYn().equals("y")){
			openGame();
			methGO();
		}else{
			methAddMe();
			methAddPlayers();
			methGO();
		}
	}
	void methGO(){
		int j = 0;
		do{
			aTable.removeLoosers();
			play();
			aTable.removeLoosers();
			aTable.outOfGame();
			if(aTable.getPlayers().isEmpty()){
				methAddPlayers();
			}
			saveGame();
			aView.autoSave();
			j++;
		} while(j != 10);
		aView.pause();
	}
	public void play(){
		
		makeBets();
		aTable.getCroupier().shuffle(aTable.getaDeck());
		aTable.getCroupier().shuffle(aTable.getaDeck());
		issueCard();
		issueCardCrourier();
		inspectionFirst();
		issueCardCrourier();
		inspection();
		checkWinner();
		clearHand();
	}
	public Table openGame(){
		Scanner sc; 
		Gson gson2 = new Gson();
		try {
			sc = new Scanner(new BufferedInputStream(new FileInputStream("./SaveGame.json")) );
			String res = sc.nextLine();
			aTable = gson2.fromJson(res, Table.class);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return aTable;
	}
	private void saveGame(){
		Gson gson = new Gson();
		String toJson =  gson.toJson(aTable);
		PrintWriter pw;
		try {
			pw = new PrintWriter(new BufferedOutputStream(new FileOutputStream("./SaveGame.json")) );
			pw.write(toJson);
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	private void cheat(Player p){
		if(aView.annigilation() == 1){
			p.calculate();
			for(int i = 0 ; i<aTable.getaDeck().getaDeck().size(); i++){
				if(p.getPoints()+aTable.getaDeck().getaDeck().get(i).getPoints() > 21){
					p.getHand().add(aTable.getaDeck().getaDeck().get(i));
					aView.showPlayersBack(p);
					aTable.getaDeck().getaDeck().remove(i);
					break;
				}
			}
		}else issueCardPlayer(p);
	}
	
	private void clearHand(){
		for (Player p : aTable.getPlayers()){
			aTable.getaDeck().getaDeck().addAll(p.getHand());
			p.getHand().clear();
		}
		aTable.getaDeck().getaDeck().addAll(aTable.getCroupier().getHand());
		aTable.getCroupier().getHand().clear();
	}
	
	public void inspectionFirst() {
		aView.showMyCards(aTable.getCroupier());
		aView.showCroupierBackCard(aTable.getCroupier());
		aTable.getCroupier().calculate();
		for (Player p : aTable.getPlayers()) {
			p.calculate();
			if(p.getPoints() == 21){
				if(aTable.getCroupier().getPoints() != 10 || aTable.getCroupier().getPoints() != 11){
					aView.blackJack(p);
					aView.showPlayersCard(p);
					aTable.getCroupier().setCasinoBank(aTable.getCroupier().getCasinoBank() - (p.getBet() + p.getBet()));
					p.setBalance(p.getBalance()+ (p.getBet()*3));
				}else{
					if(aView.askGiveMoney() == 1){
						aView.takeMoney(p);
						aView.showPlayersCard(p);
						p.setBalance(p.getBalance()+p.getBet());
					}
				}
			}
		}
	}

	private void zeroCash(Player p){
		aTable.getCroupier().setCasinoBank(aTable.getCroupier().getCasinoBank() + p.getBet());
	}
	
	
	private void inspection() {
		aTable.getCroupier().calculate();
		for (Player p : aTable.getPlayers()) {
			p.calculate();
			while(p.getPoints() < 17){
				if(aView.moreCard(p) == 1){
					if(aTable.getCroupier().getCasinoBank() < 50000 && p.getPoints() > 12){
						if(p.getPoints() + aTable.getaDeck().getaDeck().get(0).getPoints() == 20){
							cheat(p);
							
						}else if(p.getPoints() + aTable.getaDeck().getaDeck().get(0).getPoints() == 21){
			
							cheat(p);
							
						}else {
							issueCardPlayer(p);
							
						}
					}else{
						issueCardPlayer(p);
						
					}
						
				}
				p.calculate();
			}
			
			if(p.getPoints() > 21){
				aView.gameOver(p);
				aView.showPlayersCard(p);
				zeroCash(p);
			}
		}
		
		
		aView.showMyCards(aTable.getCroupier());
		aView.showMyPoints(aTable.getCroupier());
		while(aView.moreCardMe(aTable.getCroupier()) == 1){
			issueCardCrourier();
			aView.showMyCards(aTable.getCroupier());
			aTable.getCroupier().calculate();
			aView.showMyPoints(aTable.getCroupier());
		}
	}
	
	private void checkWinner() {
		aTable.getCroupier().calculate();
		for (Player p : aTable.getPlayers()) {
			p.calculate();
			if(aTable.getCroupier().getPoints() > 21){
				if(p.getPoints() <= 21){
					aTable.getCroupier().setCasinoBank(aTable.getCroupier().getCasinoBank() - p.getBet());
					p.setBalance(p.getBalance()+(p.getBet()*2));
					aView.showWinnerPlayer(p, aTable.getCroupier());
				}
			}else {
				if(p.getPoints() ==  aTable.getCroupier().getPoints()){
					p.setBalance(p.getBalance()+p.getBet());
					aView.push(p, aTable.getCroupier());
				} else if(p.getPoints() > aTable.getCroupier().getPoints() && p.getPoints()<=21){
					aTable.getCroupier().setCasinoBank(aTable.getCroupier().getCasinoBank() - p.getBet());
					p.setBalance(p.getBalance()+(p.getBet()*2));
					aView.showWinnerPlayer(p, aTable.getCroupier());
				} else if(p.getPoints() < aTable.getCroupier().getPoints()){
					aTable.getCroupier().setCasinoBank(aTable.getCroupier().getCasinoBank() + p.getBet());
					aView.showWinnerCroupier(aTable.getCroupier(),p);
				}
			}
		}
	}
	
	public void issueCard() {
		for(Player p : aTable.getPlayers()){
			p.takeCard(aTable.getCroupier(), aTable.getaDeck());
			p.takeCard(aTable.getCroupier(), aTable.getaDeck());
			aView.showPlayersBackCard(p);
		}
	}
	
	private void issueCardPlayer(Player p){
		p.takeCard(aTable.getCroupier(), aTable.getaDeck());
		aView.showPlayersBack(p);
	}
	
	public void issueCardCrourier(){
		aTable.getCroupier().takeCard(aTable.getaDeck());
		
	}
	
	public void makeBets(){
		for(Player p : aTable.getPlayers()){
			int bet = aView.makeBet(p);
			if(bet > 0){
				p.makeBet(bet);
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				aView.accepted(p);
			}else makeBets();
				
		}
	}
}
