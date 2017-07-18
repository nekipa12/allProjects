package edu.shag.lesson16.seaBattleClient.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import edu.shag.lesson16.seaBattleClient.view.ViewBattlePlace;


public class ClientThread implements Runnable{
	private Socket s;
	private Scanner sc;
	private PrintWriter pw;
	private BattlePlace bp;
	private Scanner sc1;
	private ViewBattlePlace vbp;
	
	public ClientThread(Socket s) {
		
		this.s = s;
		bp = new BattlePlace();
		vbp = new ViewBattlePlace();
	}

	@Override
	public void run() {
		vbp.chooseVariant();
		Scanner scChoose = new Scanner(System.in);
		
		if(scChoose.nextInt() == 1){
			bp.startMe();
		}else{
			bp.start();
		}
		vbp.getMapMe(bp.getAls());
		vbp.getMapOpponents();
		
		while(true){	
			String fromServer = null;
			do{
				
				try {
					sc = new Scanner(s.getInputStream());
					pw = new PrintWriter(s.getOutputStream());
				} catch (IOException e) {
					e.printStackTrace();
				}
				sc1 = new Scanner(System.in);
				fromServer = null;
				String toServer = sc1.nextLine();
				pw.write(toServer + "\n");
				pw.flush();
				fromServer = sc.nextLine();
				if(fromServer.equals("мимо")){
					vbp.editFalse(toServer);
				}else {
					vbp.editTrue(toServer);
				}
				if(fromServer.equals("потопил")){
					vbp.underWater();
				}
				if(fromServer.equals("Вы победили")){
					vbp.youAreWinner();
					return;
				}
				vbp.showMapOpponents();
				
			}while(!fromServer.equals("мимо"));
			String ttt;
			do{
				try {
					sc = new Scanner(s.getInputStream());
					pw = new PrintWriter(s.getOutputStream());
				} catch (IOException e) {
					e.printStackTrace();
				}
				fromServer = null;
				sc1 = new Scanner(System.in);
				fromServer = sc.nextLine();
				ttt = bp.check(fromServer);
				String g = null;
				if(ttt.equals("попал")){
					g = bp.remove(fromServer);
					if(bp.empty()){
						pw.write("Вы победили" + "\n");
						pw.flush();
						return;
					}else{
						vbp.editTrueMy(fromServer);
						vbp.showMapMy();
						pw.write(g + "\n");
						pw.flush();
						g = null;
					}
					
				}else{
					vbp.editFalseMy(fromServer);
					vbp.showMapMy();
					pw.write(ttt + "\n");
					pw.flush();
				}
			}while(!(ttt.equals("мимо")));
		}	
	}
}
