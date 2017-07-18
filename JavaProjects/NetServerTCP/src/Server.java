import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	
	public static void main(String[] args) {
		
		try {
			ServerSocket ss = new ServerSocket(5916);
			while (true) {
				Socket s = ss.accept();
				ServerInTh st = new ServerInTh(s);
				Thread t = new Thread(st);
				t.start();
			}
		} catch (IOException e) {
		}

	}

}
