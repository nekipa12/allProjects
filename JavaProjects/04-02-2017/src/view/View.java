package view;

import java.util.Scanner;

import model.Player;

public class View {
	Scanner scLines;
	Scanner scDigits;
	public View(){
		scLines= new Scanner(System.in);
		scDigits= new Scanner(System.in);
	}
	
	public int inputNBones(){
		System.out.println("Input  nBones : ");
		if(scDigits.hasNextInt()) return scDigits.nextInt();
		else return 2;
	}
	public int inputBalance(){
		System.out.println("Input balance : ");
		if(scDigits.hasNextInt()) return scDigits.nextInt();
		else return 2;
	}
	public String inputName(){
		System.out.println("Input player`s name : ");
		return scLines.nextLine();
	}
	public  void showPlayer(Player p) {
		System.out.println(p.toString());
	}
	public int askNumPlayers(){
		System.out.println("How many players will be playing dice");
		return scDigits.nextInt();
	}
	public boolean playAgain(){
		System.out.println("Want to play again? y/n");
		String answer = scLines.nextLine();
		if(answer.equals("y") || answer.equals("yes")){
			return true;
		}
		return false;
	}
	public int makeBet(Player p){
		System.out.println("Player " + p.getName() + " , your balance is " + p.getBalance() + ". Make bet");
		if( scDigits.hasNextInt()) return scDigits.nextInt();
		return 0;
	}

	public void askToRoll(Player p) {
		
		System.out.println("Player " + p.getName() + " press any key to roll");
		scLines.nextLine();
		for( int i=0; i<5; i++){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print(".");
		}
		System.out.println();
		
	}

	public void showWinner(Player player) {
		System.out.println("Winner" + player.getName() + " " + player.getBalance() );
		
	}

}
