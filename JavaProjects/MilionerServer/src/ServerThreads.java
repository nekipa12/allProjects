import java.awt.print.Printable;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThreads implements Runnable {
	private Socket s;
	private Question q;
	
	public ServerThreads(Socket s) {
		this.s = s;
		q = new Question();
	}

	@Override
	public void run() {
		try {
			PrintWriter pw = new PrintWriter(s.getOutputStream());
			pw.write(q.getMap().keySet().iterator().next().toString() + "\n");
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
