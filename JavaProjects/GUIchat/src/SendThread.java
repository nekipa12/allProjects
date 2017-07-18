import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;



public class SendThread implements Runnable {
	private Socket s;
	private String msg;
	private PrintWriter pw;
	
	public SendThread(Socket s, String m) {
		this.s = s;
		this.msg = m;
		try {
			pw = new PrintWriter(s.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		pw.write(msg + "\n");
		pw.flush();
	}
	
	
}
