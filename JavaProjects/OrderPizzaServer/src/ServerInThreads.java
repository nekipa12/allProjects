
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.google.gson.FieldAttributes;





public class ServerInThreads {
	private ServerSocket ss;
	public static ArrayList<Socket> clients;
	public static String key = null;
	public static String msg = null;
	private int id;
	
	
	
	public ServerInThreads() {
		clients = new ArrayList<>();
		
	}
	public void start() {
		 try {
			ss = new ServerSocket(63521);
			while (true) {
				Socket s = ss.accept();
				id++;
				ServerThreads st = new ServerThreads(s, id);
				Thread t = new Thread(st);
				t.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
