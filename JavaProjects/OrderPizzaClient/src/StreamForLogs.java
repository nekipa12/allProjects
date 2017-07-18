import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class StreamForLogs implements Runnable {
	private Socket s;
	private String massage;
	private PrintWriter pw;
	
	public StreamForLogs(Socket s, String string) {
		this.s = s;
		this.massage = string;
	}

	@Override
	public void run() {
		try {
			pw = new PrintWriter(s.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		pw.write("logs" + "\n");
		pw.flush();
		
		pw.write(massage + "\n");
		pw.flush();
		
	}

}
