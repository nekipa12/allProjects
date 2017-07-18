import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JLabel;

public class Work implements Runnable {
	WhoWants ww;
	Socket s;
	Scanner sc;
	public Work(Socket s) {
		this.s = s;
		try {
			sc = new Scanner(s.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ww = new WhoWants();
		ww.start();
		
	}

	@Override
	public void run() {
		String g = sc.nextLine();
		addLable(g);
		
		
	}
	public void addLable(String g) {
		ww.getLblL().setText(g);
	}
}
