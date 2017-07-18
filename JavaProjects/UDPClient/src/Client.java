import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Client {

	public static void main(String[] args) {
		DatagramSocket clientSocket = null;
		try {
			clientSocket = new DatagramSocket();
			try {
				InetAddress IP = InetAddress.getByName("localhost");
				Scanner keyboard = new Scanner(System.in);
				System.out.println("input sentence");
				String sentence = keyboard.nextLine();
				byte [] sendData = sentence.getBytes();
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IP, 1634);
				try {
					clientSocket.send(sendPacket);
				} catch (IOException e) {
					e.printStackTrace();
				}
				byte [] receiveData = new byte [1024];
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				try {
					clientSocket.receive(receivePacket);
				} catch (IOException e) {
					e.printStackTrace();
				}
				String res = new String(receivePacket.getData(), 0, receivePacket.getLength());
				System.out.println(res);
				
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} finally {
			clientSocket.close();
		}

	}

}
