import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Client {

	int port;
	String ip;
	String nick;
	Socket socket;
	PrintWriter pw;
//	Scanner scanner;
	
	public void start() {
		connect();
		ListenerThread lt = new ListenerThread(socket);
		Thread t = new Thread(lt);
		t.start();
		
		
	}

	public Client(int port, String ip, String nick) {
		this.port = port;
		this.ip = ip;
		this.nick = nick;
	}

	public void connect()
	{
		try {
			socket = new Socket(ip,port);
			pw = new PrintWriter(socket.getOutputStream());
//			scanner = new Scanner(socket.getInputStream());
			pw.write(nick + " has come\n");
			pw.flush();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Socket getSocket() {
		return socket;
	}
	
	
	
}
