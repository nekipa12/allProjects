import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Start implements Runnable{
	private Socket s;
	private PrintWriter pw;
	private String msg;
	
	
	public Start() {
		
		
	}

	@Override
	public void run() {
		connect();
		try {
			pw = new PrintWriter(s.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		pw.write("Admin" + "\n");
		pw.flush();
		try {
			Scanner sc = new Scanner(s.getInputStream());
			String f = sc.nextLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		pw.write(msg + "\n");
		pw.flush();
		pw.write("0" + "\n");
		pw.flush();
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