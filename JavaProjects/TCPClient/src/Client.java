import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Client {

	public static void main(String[] args) throws IOException {
		
		Socket s = new Socket("127.0.0.1", 5916);
		Scanner sc = new Scanner(s.getInputStream());
		Scanner keyboard = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(s.getOutputStream());
		String toServer;
		String fromServer;
		while (true){
			toServer = keyboard.nextLine();
			if(toServer.equals("end")){
				pw.write("##!@");
				pw.flush();
				break;
			}
			pw.write(toServer + "\n");
			pw.flush();
			fromServer = sc.nextLine();
			System.out.println(fromServer);
		}
		s.close();
		sc.close();
		pw.close();

	}

}
