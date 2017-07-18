import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class WordsServer {
	public static void main(String [] args){
		try {
			ServerSocket ss = new ServerSocket(6953);
			System.out.println("waiting for client...");
			Socket s = ss.accept();
			System.out.println("got it");
			ServerThread st = new ServerThread(s);
			Thread t = new Thread(st);
			t.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
