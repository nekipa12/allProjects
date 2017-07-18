package edu.shag.lesson11.oop;

import java.util.Random;

public class Game {
	
	Player p1;
	Player p2; //агрегирование, полями класса Game являются экземпляры класса Player
	Referee r;
	int points1, points2;
	Random rnd;
	
	public Game(){
		p1 = new Player("Gomer", 25, 80, 30, 20);
		p2 = new Player("Bart", 15, 50, 15, 14);
		r = new Referee("Boobs", 22, 50, 108);
		points1 = 0;
		points2 = 0;
		rnd = new Random();
	}
	
	public void startGame(){
		System.out.println("Игра началась");
		//TODO
	}
	
	public void makeTurn(){
		int probability = rnd.nextInt(6); 					//0.1.2-first
		if(p1.getSkill()>p2.getSkill())	probability-=2;		//3.4.5-second
		else probability+=2;
		if(r.getSkill()<70){
			int k = rnd.nextInt(3);
			if(k==2) probability++;
			else if(k==2) probability--;
		}
		if(probability<=2) {points1++; System.out.println("Гейм за первым игроком "+points1);}
		else {points2++; System.out.println("Гейм за вторым игроком "+ points2);}
	}									
	
	public void playGame(){
		startGame();
		while(points1 != 11 && points2 != 11){
			for (int i = 0; i<3; i++){
				p1.play();
				p2.play();
				System.out.print(".");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			makeTurn();
		}
		if (points1 ==11){
			System.out.println("Победитель" + p1.getName());
			p1.setNumOfGamesWon(p1.getNumOfGamesWon()+1);
			p2.setNumOfGamesLost(p2.getNumOfGamesLost()+1);
		}
		else System.out.println("Победитель" + p2.getName());
	}
}
