import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class ServerThread implements Runnable {
	Socket s;
	Scanner sc;
	PrintWriter pw;
	WordController wc;
	public ServerThread(Socket s) {
		
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
		String word = wc.nextWord();
		pw.write(word + "\n");
		pw.flush();
		while (true){
			String fromClient = sc.nextLine();
			String answer = wc.check(fromClient);
			pw.write(answer + "\n");
			pw.flush();
		}
	}
	
	

}
