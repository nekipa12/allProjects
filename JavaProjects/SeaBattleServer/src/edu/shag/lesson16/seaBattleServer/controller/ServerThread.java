package edu.shag.lesson16.seaBattleServer.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import edu.shag.lesson16.seaBattleServer.view.ViewBattlePlace;

public class ServerThread implements Runnable {
	private Socket s;
	private Scanner sc;
	private PrintWriter pw;
	private BattlePlace bp;
	private String fromClient;
	private Scanner scToClient;
	private String toClient;
	private String result;
	private ViewBattlePlace vbp;
	
	public ServerThread(Socket s) {
		
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
			do {
				result = null;
				try {
					sc = new Scanner(s.getInputStream());
					pw = new PrintWriter(s.getOutputStream());
				} catch (IOException e) {
					e.printStackTrace();
				}
				fromClient = sc.nextLine();
				result = bp.check(fromClient);
				String g = null;
				if(result.equals("попал")){
					g = bp.remove(fromClient);
					if(bp.empty()){
						pw.write("Вы победили" + "\n");
						pw.flush();
						return;
					}else{
						vbp.editTrueMy(fromClient);
						vbp.showMapMy();
						pw.write(g + "\n");
						pw.flush();
						g = null;
					}
				}else{
					vbp.editFalseMy(fromClient);
					vbp.showMapMy();
					pw.write(result + "\n");
					pw.flush();
				}
			}while(!(result.equals("мимо")));	
			do{
				try {
					sc = new Scanner(s.getInputStream());
					pw = new PrintWriter(s.getOutputStream());
				} catch (IOException e) {
					e.printStackTrace();
				}
				scToClient = new Scanner(System.in);
				toClient = scToClient.nextLine();
				pw.write(toClient + "\n");
				pw.flush();
				fromClient = sc.nextLine();
				if(fromClient.equals("мимо")){
					vbp.editFalse(toClient);
				}else {
					vbp.editTrue(toClient);
				}
				if(fromClient.equals("потопил")){
					vbp.underWater();
				}
				if(fromClient.equals("Вы победили")) {
					vbp.youAreWinner();
					return;
				}
				vbp.showMapOpponents();
			}while(!(fromClient.equals("мимо")));
		}
		
	}
}
