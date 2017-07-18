import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;


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
		
		
		while(true){
			
			msg = sc.nextLine();
			if(msg.equals("end")){
				break;
			}
			ViewOperator.dlm.remove(Integer.parseInt(msg));
			Operator.gson.remove(Integer.parseInt(msg));
		}
	}

}
