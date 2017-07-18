import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JOptionPane;


public class SendThread implements Runnable {

	Socket socket;
	PrintWriter pw;
	String message;
	
	
	public SendThread(Socket socket, String m) {
		
		try 
		{
			this.message = m;
			this.socket = socket;
			this.pw = new PrintWriter(socket.getOutputStream());
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
					
	}
	
	public void run()
	{
		pw.write(message + "\n");
		pw.flush();
		JOptionPane.showMessageDialog(null, message);
	}
	
}
