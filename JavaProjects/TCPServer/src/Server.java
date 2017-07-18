import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Server {

	public static void main(String[] args) throws IOException {//однопоточный TCP сервер
		
		ServerSocket ss = new ServerSocket(5916);// передать номер потрта 1...65535
		Socket clientSocket = ss.accept();//метод блокирующий, ждет входязего подключения клиента
		Scanner sc = new Scanner(clientSocket.getInputStream());
		PrintWriter pw = new PrintWriter(clientSocket.getOutputStream());
		String fromClient;
		String toClient;
		
		Scanner keyboard = new Scanner(System.in);
		
		while (true){
			fromClient = sc.nextLine();
			if(fromClient.equals("##!@")) break;
			System.out.println(fromClient);
			toClient = keyboard.nextLine();
			pw.write(toClient + "\n");
			pw.flush();
			
		}
		clientSocket.close();
		pw.close();
		sc.close();

	}

}
