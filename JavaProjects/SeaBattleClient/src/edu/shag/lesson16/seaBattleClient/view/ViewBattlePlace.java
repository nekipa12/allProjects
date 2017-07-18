package edu.shag.lesson16.seaBattleClient.view;

import java.util.ArrayList;

import edu.shag.lesson16.seaBattleClient.model.Direction;
import edu.shag.lesson16.seaBattleClient.model.Ship;

public class ViewBattlePlace {
	private Direction dir;
	private String [][] drawMe;
	private String [][] drawOpponents;
	
	public void getMapMe(ArrayList<Ship> als) {
		drawMe = new String[10][10];
		makePlace(drawMe);
		for(Ship ss : als){
			for(String st : ss.getLocation()){
				String[] ff = st.split("");
				int t = Integer.parseInt(ff[1]);
				drawMe[dir.valueOf(ff[0]).getDigit()][t] = "B";
			}
		}
		field();
		map(drawMe);
	}

	public void getMapOpponents() {
		drawOpponents = new String[10][10];
		makePlace(drawOpponents);
		field();
		map(drawOpponents);
	}
	
	private void makePlace(String[][] draw) {
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				draw[i][j] = "'";
			}
		}
		
	}
	private void field() {
		for(int i = 0; i < 10; i++){
			if(i == 0){
				System.out.print("  "+i);
			}else {
				System.out.print(" "+i);
			}
			
		}
		System.out.println();
		
	}
	
	public void map(String[][] draw) {
		for(int i = 0; i < draw.length; i++){
			System.out.print(dir.values()[i]+ " ");
			for(int j = 0; j < draw[i].length; j++){
				System.out.print(draw[i][j] + " ");
			}
			System.out.println();
		}
		
	}

	public void editFalse(String toServer) {
		String [] s = toServer.split("");
		int t = Integer.parseInt(s[1]);
		drawOpponents[dir.valueOf(s[0]).getDigit()][t] = "*";
	}
	public void editFalseMy(String fromServer) {
		String [] s = fromServer.split("");
		int t = Integer.parseInt(s[1]);
		drawMe[dir.valueOf(s[0]).getDigit()][t] = "*";
	}
	public void editTrue(String toServer) {
		String [] s = toServer.split("");
		int t = Integer.parseInt(s[1]);
		drawOpponents[dir.valueOf(s[0]).getDigit()][t] = "X";
		
	}

	public void showMapOpponents() {
		field();
		for(int i = 0; i < drawOpponents.length; i++){
			System.out.print(dir.values()[i]+ " ");
			for(int j = 0; j < drawOpponents[i].length; j++){
				System.out.print(drawOpponents[i][j] + " ");
			}
			System.out.println();
		}
		
	}

	public void showMapMy() {
		field();
		for(int i = 0; i < drawMe.length; i++){
			System.out.print(dir.values()[i]+ " ");
			for(int j = 0; j < drawMe[i].length; j++){
				System.out.print(drawMe[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void editTrueMy(String fromServer) {
		String [] s = fromServer.split("");
		int t = Integer.parseInt(s[1]);
		drawMe[dir.valueOf(s[0]).getDigit()][t] = "X";
		
	}

	public void youAreWinner() {
		System.out.println("You are winner");
		
	}

	public void underWater() {
		System.out.println("Потопил");
		
	}

	public void input(String name) {
		System.out.println("Введите локацию для " + name + "-мерного корабля");
		
	}

	public void chooseVariant() {
		System.out.println("Выберите вариант заполнения");
		System.out.println("1 - заполняете сами");
		System.out.println("2 - заполить рандомно");
	}

	
	
}
