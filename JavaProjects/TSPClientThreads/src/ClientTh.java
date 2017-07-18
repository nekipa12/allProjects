import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


public class ClientTh {

	public static void main(String[] args) {
		
		try {
			
			Socket s = new Socket("127.0.0.1", 5916);
			DataInputStream dis = new DataInputStream(s.getInputStream());
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			dos.writeInt(5); 
			dos.writeInt(7);
			
			int res = dis.readInt();
			System.out.println(res);
			
		} catch (UnknownHostException e) {
		} catch (IOException e) {}

		
	}

}
