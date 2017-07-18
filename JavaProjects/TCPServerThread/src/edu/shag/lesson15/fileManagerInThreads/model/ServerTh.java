package edu.shag.lesson15.fileManagerInThreads.model;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerTh {

	public static void main(String[] args) {
		
		try {
			ServerSocket ss = new ServerSocket(5916);
			while (true) {
				Socket s = ss.accept();
				ServerThreads st = new ServerThreads(s);
				Thread t = new Thread(st);
				t.start();
			}
		} catch (IOException e) {
		}

	}

}


