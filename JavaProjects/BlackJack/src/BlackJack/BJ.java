package BlackJack;

import java.util.Scanner;

import controller.CroupierGameplay;
import controller.PlayerGameplay;

public class BJ {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Выберите режим");
		System.out.println("Нажмите 1 чтобы играть за крупье, 2 чтобы играть за игрока");
		int choose = sc.nextInt();
		if(choose == 1){
			System.out.println("Вы выбрали игру за КРУПЬЕ");
			System.out.println();
			CroupierGameplay aGame = new CroupierGameplay();
			aGame.start();
		}else{
			System.out.println("Вы выбрали игру за ИГРОКА");
			System.out.println();
			PlayerGameplay ad = new PlayerGameplay();
			ad.start();
		}
		sc.close();
		
		
	}	
	
}
