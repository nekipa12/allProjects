package edu.shag.lesson16.seaBattleServer.seabattle;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import edu.shag.lesson16.seaBattleServer.controller.ServerThread;


public class SeaBattleServer {
	public static void main(String [] args){
		try {
			ServerSocket ss = new ServerSocket(6953);
			System.out.println("waiting for client...");
			Socket s = ss.accept();
			System.out.println("got it");
			ServerThread st = new ServerThread(s);
			Thread t = new Thread(st);
			t.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
