package BlackJack;

import java.util.Scanner;

import controller.CroupierGameplay;
import controller.PlayerGameplay;

public class BJ {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�������� �����");
		System.out.println("������� 1 ����� ������ �� ������, 2 ����� ������ �� ������");
		int choose = sc.nextInt();
		if(choose == 1){
			System.out.println("�� ������� ���� �� ������");
			System.out.println();
			CroupierGameplay aGame = new CroupierGameplay();
			aGame.start();
		}else{
			System.out.println("�� ������� ���� �� ������");
			System.out.println();
			PlayerGameplay ad = new PlayerGameplay();
			ad.start();
		}
		sc.close();
		
		
	}	
	
}
