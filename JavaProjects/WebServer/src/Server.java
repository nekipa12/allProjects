import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Server {

	public static void main(String[] args) {
		try {
			ServerSocket listenSocket = new ServerSocket(80);
			
			
			while(true) {
				final Socket s = listenSocket.accept();
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						
						try {
							Scanner sc = new Scanner(s.getInputStream());
							DataOutputStream dos = new DataOutputStream(s.getOutputStream());
							String requestMessage = sc.nextLine();
							System.out.println(requestMessage);
							String [] request = requestMessage.split(" ");
							if(request.length == 3 && request[0].equals("GET")){
								File file = new File("./" + request[1]);
								if(file.isDirectory()){
									file = new File(file.getPath() + "/index.html");
								}
								if(file.exists()){
									String filePath = file.getPath();
									FileInputStream inFile = new FileInputStream(file);
									System.out.println("Requested file is " + filePath);
									int fileSize = (int)file.length();// для заголовка	
									byte [] fileContent = new byte [fileSize];
									inFile.read(fileContent);
									dos.writeBytes("HTTP/1.0 20 OK\r\n");
									if(filePath.endsWith(".jpg")){
										dos.writeBytes("Content-Type: image/jpeg\r\n");
									} else {
										dos.writeBytes("Content-Type: text/html\r\n");
									}
									dos.writeBytes("Content-Lenght: " + fileSize + "\r\n");
									dos.writeBytes("\r\n");
									dos.write(fileContent);
								} else {
									//404 error
									System.out.println("file not found" + file.getPath());
								}
							} else {
								System.out.println("Bad header");
							}
							
							
						} catch (Exception e) {
							e.printStackTrace();
						}finally {
							try {
								s.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						
							
						
						
						
						
					}
				}).start();
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
