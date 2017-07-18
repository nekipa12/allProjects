import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class WorkWithClientThread implements Runnable {

	Socket s;
	ArrayList<Socket> clients;
	Scanner sc;
	PrintWriter pw;
	String message;
	
	public WorkWithClientThread(Socket s, ArrayList<Socket> clients) {
		this.s = s;
		this.clients = clients;
	}

	@Override
	public void run() {
		try {
			sc = new Scanner(s.getInputStream());
			
			while(true)
			{
				message = sc.nextLine();
				JOptionPane.showMessageDialog(null, "SERVER:"+message);
				for(Socket aClient : clients){
					pw = new PrintWriter(aClient.getOutputStream());
					pw.write(message+"\n");
					pw.flush();
				}
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
