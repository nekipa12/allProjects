
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;

public class ServerInTh implements Runnable {

	private Socket s;
	private PrintWriter pw;
	
	public ServerInTh(Socket s) {
		this.s = s;
	}
	
	@Override
	public void run(){
		try {
			while(true){
				Scanner sc = new Scanner(s.getInputStream());
				pw = new PrintWriter(s.getOutputStream());
				String fromClient = sc.nextLine();
				if(fromClient.equals("##!@")){
					pw.close();
					s.close();
					sc.close();
					break;
				}
				if(fromClient.equals("dir")){
					dir();
				}else if(fromClient.equals("copy")){
					while (true){
						fromClient = sc.nextLine();
						if(fromClient.equals("nuf")) break;
						else{
							String [] fro = fromClient.split(" ");
							copy(fro[0], fro[1]);
						}
					}
				}
			}	
		} catch (IOException e) {
			System.out.println("Соединение прервано");
		}
	}

	private void copy(String fromClient, String fromClientDirectory) {
		
		int from = Integer.parseInt(fromClient);
		File f = new File("D:/JAVA/Projects/NetServerTCP/фото/");
		File [] fm = f.listFiles();
		InputStream is = null;
		OutputStream os = null;
		try{
			try {
				is = new FileInputStream("D:/JAVA/Projects/NetServerTCP/фото/" + fm[from].getName() );
				os = new FileOutputStream(fromClientDirectory + fm[from].getName());
			} catch (FileNotFoundException e) {
			}
			byte [] buffer = new byte [1024];
			int lenght;
			try {
			while((lenght = is.read(buffer))>0){
				os.write(buffer, 0, lenght);
				}
			} catch (IOException e) {
			}
		} finally{
			try {
				is.close();
				os.close();
			} catch (IOException e) {
			}
		}
	}

	private void dir() {
		
		File f = new File("D:/JAVA/Projects/NetServerTCP/фото/");
		File [] fm = f.listFiles();
		ArrayList<String> al = new ArrayList<>();
		Gson gson = new Gson();
		for(File s : fm){
			al.add(s.getName());
		}
		String toJson =  gson.toJson(al);
		pw.write(toJson + "\n");
		pw.flush();
	}

}
