
import java.net.Socket;


public class WordsClient {

	public static void main(String[] args) {
		try {
			Socket s = new Socket("127.0.0.1",6953);
			ClientThread st = new ClientThread(s);
			Thread t = new Thread(st);
			t.start();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
