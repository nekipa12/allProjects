package edu.shag.lesson15.model.client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


public class NetModel {
	private Socket s;
	private String host;
	private int port;
	
	public Socket getS() {
		return s;
	}

	public NetModel(String host, int port) {
		
		try {
			s = new Socket(host, port);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
