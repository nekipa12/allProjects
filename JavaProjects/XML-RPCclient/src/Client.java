import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;
import java.util.Vector;

import org.apache.xmlrpc.XmlRpcClient;
import org.apache.xmlrpc.XmlRpcException;


public class Client {

	public static void main(String[] args) {
		try {
			XmlRpcClient client = new XmlRpcClient("http://localhost:8082");
			Vector<Integer> params = new Vector<>();//в него нужно положить все агрументы метода...если разного типа тогра анрумаент обжект
			Scanner sc = new Scanner(System.in);
			int amount = sc.nextInt();
			params.add(amount);
			try {
				Object res = client.execute("exchange.USD_UAH", params);
				System.out.println(res);
			} catch (XmlRpcException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

}
