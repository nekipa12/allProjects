import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class ListenerThread implements Runnable {
	
	private Socket s;
	private Scanner sc;
	private String msg;
	
	public ListenerThread(Socket s) {
		this.s = s;
		try {
			sc = new Scanner(s.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		do {
			msg = sc.nextLine();
			Main.textArea.append("\n" + msg);
		} while(!msg.equals("#@!123#@!"));
		try {
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
