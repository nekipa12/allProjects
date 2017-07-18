import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class Server {
	private int port;
	private ServerSocket ss;
	private ArrayList<Socket> clients;
	
	public Server(int port) {
		this.port = port;
		clients = new ArrayList<>();
	}


	public void start() {
		 try {
			ss = new ServerSocket(port);
			ServerListenerThread st = new ServerListenerThread(ss, clients);
			Thread t = new Thread(st);
			t.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
