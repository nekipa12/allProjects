import java.util.Scanner;

import javax.swing.text.DefaultEditorKit.CutAction;

import org.apache.xmlrpc.WebServer;


public class Server {
	private static double cuttency;
	public Server(double cuttency) {
		this.cuttency = cuttency;
	}
	public double USD_UAH(int amount){
		return amount*cuttency;
	}
	public static void main(String [] args){
		WebServer server = new WebServer(8082);
		Scanner sc = new Scanner(System.in);
		cuttency = sc.nextInt();
		server.addHandler("exchange", new Server(cuttency));
		server.start();
		System.out.println("Server was be started successfully");
	}
}
