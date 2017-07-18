import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class ServerListenerThread implements Runnable {
	
	ServerSocket ss;
	ArrayList<Socket> clients;
	
	
	@Override
	public void run() {
		while(true)
		{
			try {
				final Socket s = ss.accept();
				clients.add(s);
				WorkWithClientThread wt = new WorkWithClientThread(s,clients);
				Thread t = new Thread(wt);
				t.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


	public ServerListenerThread(ServerSocket ss, ArrayList<Socket> clients) {
		this.ss = ss;
		this.clients = clients;
	}

	
	
}
