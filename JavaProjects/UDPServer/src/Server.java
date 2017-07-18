import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;


public class Server {

	public static void main(String[] args) {
		try {
			DatagramSocket serverSocket = new DatagramSocket(1634);
			byte [] receiveData = new byte[1024];
			byte [] sendData;
			int count = 3;
			while(count > 0){
				DatagramPacket packet = new DatagramPacket(receiveData, receiveData.length);
				serverSocket.receive(packet);
				String fromClient = new String(packet.getData(), 0, packet.getLength());
				sendData = fromClient.toUpperCase().getBytes();
				packet.setData(sendData);
				serverSocket.send(packet);
				count--;
			}
			serverSocket.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
