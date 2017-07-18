import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	public static Socket s;
	private PrintWriter pw;
	
	
	
	public Socket getS() {
		return s;
	}
	public Client() {
		
	}
	
	public void start(){
		connect();
		Work w = new Work(s);
		Thread t = new Thread(w);
		t.start();
	}
	
	public void connect(){
		try {
			s = new Socket("localhost", 63521);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
