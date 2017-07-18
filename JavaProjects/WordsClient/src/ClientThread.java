import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class ClientThread implements Runnable{
	Socket s;
	Scanner sc;
	PrintWriter pw;
	WordController wc;
	public ClientThread(Socket s) {
		
		this.s = s;
		wc = new WordController();
	}

	@Override
	public void run() {
		try {
			sc = new Scanner(s.getInputStream());
			pw = new PrintWriter(s.getOutputStream());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		while (true){
			String fromServer = sc.nextLine();
			String answer = wc.check(fromServer);	
			pw.write(answer + "\n");
			pw.flush();
		}
	}

}
