

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;








public class ServerInThreads {
	private ServerSocket ss;
	
	
	
	public ServerInThreads() {
		
	}
	public void start() {
		 try {
			ss = new ServerSocket(63521);
			while (true) {
				Socket s = ss.accept();
				ServerThreads st = new ServerThreads(s);
				Thread t = new Thread(st);
				t.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
