import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;


public class WorkWithClientThread implements Runnable{
	private Socket s;
	private ArrayList<Socket> as;
	private Scanner sc;
	private PrintWriter pw;
	private String msg;
	
	public WorkWithClientThread(Socket s, ArrayList<Socket> as) {
		this.s = s;
		this.as = as;
	}

	@Override
	public void run() {
		try {
			sc = new Scanner(s.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		while(true){
			msg = sc.nextLine();
			for(Socket concrClient : as){
				try {
					pw = new PrintWriter(concrClient.getOutputStream());
				} catch (IOException e) {
					e.printStackTrace();
				}
				pw.write(msg + "\n");
				pw.flush();
			}
		}
	}
	
	
}
