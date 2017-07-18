import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Client {
	
	private int port;
	private String ip;
	private String nick;
	private Socket s;
	private PrintWriter pw;
	
	
	public Socket getS() {
		return s;
	}

	public Client(int port, String ip, String nick) {
		this.port = port;
		this.ip = ip;
		this.nick = nick;
	}
	
	public void connect(){
		try {
			s = new Socket(ip, port);
			pw = new PrintWriter(s.getOutputStream());
			
			pw.write(nick + " has came in chat" + "\n");
			pw.flush();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void start(){
		connect();
		ListenerThread lt = new ListenerThread(s);
		Thread t = new Thread(lt);
		t.start();
	}
}
