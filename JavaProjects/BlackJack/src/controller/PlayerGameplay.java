package controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import com.google.gson.Gson;
import model.Card;
import model.Deck;
import model.Player;
import model.Table;
import view.Intro;
import view.ViewForCroupier;
import view.ViewForPlayer;

public class PlayerGameplay {
	private Table bTable;
	private int numPlayers;
	private Intro intro;
	private ViewForPlayer bView;
	private ViewForCroupier aView;
	private ArrayList<Card> prom;
	private int ch;
	
	public PlayerGameplay(){
		bView = new ViewForPlayer();
		aView = new ViewForCroupier();
		bTable = new Table();
		intro = new Intro();
		prom = new ArrayList<>();
		
	}
	void methAddMe(){
		String name = bView.inputName();
		int balance = bView.inputBalance();
		bTable.addMeImPlayer(name, balance);
	}
	void methAddCroupier(){
		bTable.addMePlease("Genri", 25000);
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
			bTable.addPlayer(name, balance);
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			aView.showPlayer(bTable.getPlayers().get(i));
		}
	}
	public void start(){
		intro.introForPlayer();
		
		if(aView.methYn().equals("y")){
			openGame();
			methGO();
			
		}else{
			methAddMe();
			methAddCroupier();
			methAddPlayers();
			methGO();
		}
	}
	void methGO(){
		bView.o(bTable.getCroupier());
		int j = 0;
		do{
			bTable.removeLoosers();
			play();
			bTable.removeLoosers();
			bTable.outOfGame();
			if(bTable.getPlayers().isEmpty()){
				methAddPlayers();
			}
			saveGame();
			aView.autoSave();
			j++;
		} while(j != 10);
		aView.pause();
	}
	public Table openGame(){
		Scanner sc; 
		Gson gson2 = new Gson();
		try {
			sc = new Scanner(new BufferedInputStream(new FileInputStream("./SaveGamePlayer.json")) );
			String res = sc.nextLine();
			bTable = gson2.fromJson(res, Table.class);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return bTable;
	}
	private void saveGame(){
		Gson gson = new Gson();
		String toJson =  gson.toJson(bTable);
		PrintWriter pw;
		try {
			pw = new PrintWriter(new BufferedOutputStream(new FileOutputStream("./SaveGamePlayer.json")) );
			pw.write(toJson);
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void play(){
		
		makeBets();
		bTable.getCroupier().shuffle(bTable.getaDeck());
		bTable.getCroupier().shuffle(bTable.getaDeck());
		issueCard();
		issueCardCrourier();
		inspectionFirst();
		issueCardCrourier();
		inspection();
		gameOverCheat();
		checkWinner();
		clearHand();
	}
	private void gameOverCheat(){
		if(ch == 1){
			bView.warning();
			
		} else if(ch == 2){
			bView.warningLooser();
			bTable.getCroupier().setCasinoBank(bTable.getCroupier().getCasinoBank() + bTable.getPlayer().getBalance());
			bTable.getPlayer().setBalance(0);
			return;
		}
		return;
	}
	private void makeBets() {
		for(Player p : bTable.getPlayers()){
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
		int be = bView.meMakeBets(bTable.getPlayer());
		if(be > 0){
			bTable.getPlayer().makeBet(be);
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			aView.accepted(bTable.getPlayer());
		}else makeBets();
	}
	
	public void issueCard() {
		for(Player p : bTable.getPlayers()){
			p.takeCard(bTable.getCroupier(), bTable.getaDeck());
			p.takeCard(bTable.getCroupier(), bTable.getaDeck());
			aView.showPlayersBackCard(p);
		}
		bTable.getPlayer().takeCard(bTable.getCroupier(), bTable.getaDeck());
		bTable.getPlayer().takeCard(bTable.getCroupier(), bTable.getaDeck());
		aView.showPlayersCard(bTable.getPlayer());
	}
	
	public void issueCardCrourier(){
		bTable.getCroupier().takeCard(bTable.getaDeck());
		
	}
	public void inspectionFirst() {
		aView.showMyCards(bTable.getCroupier());
		aView.showCroupierBackCard(bTable.getCroupier());
		bTable.getCroupier().calculate();
		for (Player p : bTable.getPlayers()) {
			p.calculate();
			if(p.getPoints() == 21){
				if(bTable.getCroupier().getPoints() != 10 || bTable.getCroupier().getPoints() != 11){
					aView.blackJack(p);
					aView.showPlayersCard(p);
					bTable.getCroupier().setCasinoBank(bTable.getCroupier().getCasinoBank() - (p.getBet() + p.getBet()));
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
		bTable.getPlayer().calculate();
		if(bTable.getPlayer().getPoints() == 21){
			if(bTable.getCroupier().getPoints() != 10 || bTable.getCroupier().getPoints() != 11){
				aView.blackJack(bTable.getPlayer());
				aView.showPlayersCard(bTable.getPlayer());
				bTable.getCroupier().setCasinoBank(bTable.getCroupier().getCasinoBank() - (bTable.getPlayer().getBet() + bTable.getPlayer().getBet()));
				bTable.getPlayer().setBalance(bTable.getPlayer().getBalance()+ (bTable.getPlayer().getBet()*3));
			}else{
				if(aView.askGiveMoney() == 1){
					aView.takeMoney(bTable.getPlayer());
					aView.showPlayersCard(bTable.getPlayer());
					bTable.getPlayer().setBalance(bTable.getPlayer().getBalance()+bTable.getPlayer().getBet());
				}
			}
		}
	}
	private void cheat(Player p){
		p.calculate();
		for(int i = 0 ; i<bTable.getaDeck().getaDeck().size(); i++){
			if(p.getPoints()+bTable.getaDeck().getaDeck().get(i).getPoints() > 21){
				p.getHand().add(bTable.getaDeck().getaDeck().get(i));
				aView.showPlayersBack(p);
				bTable.getaDeck().getaDeck().remove(i);
				System.out.println("ЧИТ СРАБОТАЛ");
				break;
			}
		}
	}
	private void inspection() {
		bTable.getCroupier().calculate();
		for (Player p : bTable.getPlayers()) {
			p.calculate();
			while(p.getPoints() < 17){
				bView.moreCard(p);
				if(bTable.getCroupier().getCasinoBank() < 50000 && p.getPoints() > 12){
					if(p.getPoints() + bTable.getaDeck().getaDeck().get(0).getPoints() == 20){
						cheat(p);
					}else if(p.getPoints() + bTable.getaDeck().getaDeck().get(0).getPoints() == 21){
						cheat(p);
					}else {
						issueCardPlayer(p);
					}
				}else{
					issueCardPlayer(p);
				}
				p.calculate();
			}
			if(p.getPoints() > 21){
				aView.gameOver(p);
				aView.showPlayersCard(p);
				zeroCash(p);
			}
		}
		aView.showPlayersCard(bTable.getPlayer());
		while(bView.moreCardMe(bTable.getPlayer()) == 1){
			bTable.getPlayer().calculate();
			if(bTable.getCroupier().getCasinoBank() < 50000 && bTable.getPlayer().getPoints() > 12){
				if(bTable.getPlayer().getPoints() + bTable.getaDeck().getaDeck().get(0).getPoints() == 20){
					cheat(bTable.getPlayer());
					cheatIM();
				}else if(bTable.getPlayer().getPoints() + bTable.getaDeck().getaDeck().get(0).getPoints() == 21){
					cheat(bTable.getPlayer());
					cheatIM();
				}else {
					issueCardMe();
					cheatMe();
				}
			}else{
				issueCardMe();
				cheatMe();
			}
		}
		bTable.getPlayer().calculate();
		if(bTable.getPlayer().getPoints() > 21){
			aView.gameOver(bTable.getPlayer());
			aView.showPlayersCard(bTable.getPlayer());
			zeroCash(bTable.getPlayer());
		}
		aView.showMyCards(bTable.getCroupier());
		aView.showMyPoints(bTable.getCroupier());
		while(bTable.getCroupier().getPoints() < 17){
			issueCardCrourier();
			aView.showMyCards(bTable.getCroupier());
			bTable.getCroupier().calculate();
			aView.showMyPoints(bTable.getCroupier());
		}
	}
	private void cheatIM() {
		bTable.getPlayer().calculate();
		Deck deck = new Deck();
		Collections.shuffle(deck.getaDeck());
		ArrayList<Card> c = new ArrayList<>();
		c.add(deck.getaDeck().get(0));
		c.add(deck.getaDeck().get(1));
		c.add(deck.getaDeck().get(2));
		int ind = 0;
		for(Card ca : c){
			System.out.println(ind +" "+ca);
			ind++;
		}
		System.out.println("Замена карты");
		Scanner sc = new Scanner(System.in);
		int f = sc.nextInt();
		for(int i = 0; i < bTable.getPlayer().getHand().size(); i++){
			if(f==i){
				prom.add(bTable.getPlayer().getHand().get(i));
				bTable.getPlayer().getHand().remove(i);
				ch++;
			}
		}
		int f1 = sc.nextInt();
		for(int i = 0; i < c.size(); i++){
			if(f1 == i){
				bTable.getPlayer().getHand().add(c.get(i));
			}
		}
		
	}
	private void issueCardMe(){
		bTable.getPlayer().takeCard(bTable.getCroupier(), bTable.getaDeck());
		aView.showPlayersCard(bTable.getPlayer());
	}
	private void issueCardPlayer(Player p){
		p.takeCard(bTable.getCroupier(), bTable.getaDeck());
		aView.showPlayersBack(p);
	}
	private void zeroCash(Player p){
		bTable.getCroupier().setCasinoBank(bTable.getCroupier().getCasinoBank() + p.getBet());
	}
	private void checkWinner() {
		bTable.getCroupier().calculate();
		bTable.getPlayer().calculate();
		for (Player p : bTable.getPlayers()) {
			p.calculate();
			cW(p);
		}
		cW(bTable.getPlayer());
	}
	private void cW(Player p){
		if(bTable.getCroupier().getPoints() > 21){
			if(p.getPoints() <= 21){
				bTable.getCroupier().setCasinoBank(bTable.getCroupier().getCasinoBank() - p.getBet());
				p.setBalance(p.getBalance()+(p.getBet()*2));
				aView.showWinnerPlayer(p, bTable.getCroupier());
			}
		}else {
			if(p.getPoints() ==  bTable.getCroupier().getPoints()){
				p.setBalance(p.getBalance()+p.getBet());
				aView.push(p, bTable.getCroupier());
			} else if(p.getPoints() > bTable.getCroupier().getPoints() && p.getPoints()<=21){
				bTable.getCroupier().setCasinoBank(bTable.getCroupier().getCasinoBank() - p.getBet());
				p.setBalance(p.getBalance()+(p.getBet()*2));
				aView.showWinnerPlayer(p, bTable.getCroupier());
			} else if(p.getPoints() < bTable.getCroupier().getPoints()){
				bTable.getCroupier().setCasinoBank(bTable.getCroupier().getCasinoBank() + p.getBet());
				aView.showWinnerCroupier(bTable.getCroupier(),p);
			}
		}
	}
	private void clearHand(){
		for (Player p : bTable.getPlayers()){
			bTable.getaDeck().getaDeck().addAll(p.getHand());
			p.getHand().clear();
		}
		bTable.getaDeck().getaDeck().addAll(bTable.getCroupier().getHand());
		bTable.getCroupier().getHand().clear();
		bTable.getaDeck().getaDeck().addAll(bTable.getPlayer().getHand());
		bTable.getPlayer().getHand().clear();
	}
	private void cheatMe() {
		bTable.getPlayer().calculate();
		Deck deck = new Deck();
		Collections.shuffle(deck.getaDeck());
		ArrayList<Card> c = new ArrayList<>();
		c.add(deck.getaDeck().get(0));
		c.add(deck.getaDeck().get(1));
		c.add(deck.getaDeck().get(2));
		int ind = 0;
		for(Card ca : c){
			System.out.println(ind +" "+ca);
			ind++;
		}
		System.out.println("Замена карты");
		Scanner sc = new Scanner(System.in);
		int f = sc.nextInt();
		for(int i = 0; i < bTable.getPlayer().getHand().size(); i++){
			if(f==i){
				prom.add(bTable.getPlayer().getHand().get(i));
				bTable.getPlayer().getHand().remove(i);
			}
		}
		int f1 = sc.nextInt();
		for(int i = 0; i < c.size(); i++){
			if(f1 == i){
				bTable.getPlayer().getHand().add(c.get(i));
			}
		}
		
	}
}
