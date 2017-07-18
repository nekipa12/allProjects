import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class ListenerThread implements Runnable {

	Socket socket;
	Scanner scanner;
	String message;
	
	public ListenerThread(Socket socket) {
		this.socket = socket;
		try {
			this.scanner = new Scanner(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		do
		{
			message = scanner.nextLine();
			JOptionPane.showMessageDialog(null, "client received: " + message);
			MainFrame.textArea.append(message);
			
			
		} while(!message.equals("#111#"));
		
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
