package edu.shag.lesson15.controller.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import edu.shag.lesson15.model.server.NetModel;
import edu.shag.lesson15.model.server.NetModelInThread;

public class Work {
	
	private NetModel nm;
	private NetModelInThread nmit;
	private Socket s;
	private Thread t;
	
	public Work() {
		nm = new NetModel(5916);
	}

	public void start() {
		while (true) {
			try {
				ServerSocket ss = new ServerSocket(5916);
				s = ss.accept();
			} catch (IOException e) {
				//e.printStackTrace();
			}
			nmit = new NetModelInThread(s);
			t = new Thread(nmit);
			t.start();
		}
		
	}

}
