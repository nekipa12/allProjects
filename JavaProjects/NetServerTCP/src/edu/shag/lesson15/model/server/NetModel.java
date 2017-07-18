package edu.shag.lesson15.model.server;

import java.io.IOException;
import java.net.ServerSocket;

public class NetModel {
	
	private ServerSocket ss;
	private int port;
	
	public ServerSocket getSs() {
		return ss;
	}

	public NetModel(int port) {
		try {
			ss = new ServerSocket();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
