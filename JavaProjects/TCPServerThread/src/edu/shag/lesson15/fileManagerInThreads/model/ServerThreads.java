package edu.shag.lesson15.fileManagerInThreads.model;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class ServerThreads implements Runnable {

	private Socket s;
	private int res;
	private DataInputStream dis;
	private DataOutputStream dos;
	public ServerThreads(Socket s) {
		this.s = s;
		res = 0;
	}
	
	public void method(int a, int b) {
		res = a+b; try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void run() {
		try {
			dis = new DataInputStream(s.getInputStream());
			dos = new DataOutputStream(s.getOutputStream());
			int a = dis.readInt();
			int b = dis.readInt();
			method(a, b);
			dos.writeInt(res);
		
		} catch (IOException e) {
		} finally{
			try {
				s.close();
			} catch (IOException e) {
			}
		}
	}
}
