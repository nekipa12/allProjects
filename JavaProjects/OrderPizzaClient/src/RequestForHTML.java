import java.awt.Desktop;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class RequestForHTML implements Runnable {

	private Socket s;
	private int idx;
	private PrintWriter pw;
	private URI uri;
	
	public RequestForHTML(Socket s, int idx) {
		this.s = s;
		this.idx = idx;
		try {
			pw = new PrintWriter(s.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void run() {
		pw.write("GetHTML" + "\n");
		pw.flush();
		Scanner sc1;
		try {
			sc1 = new Scanner(s.getInputStream());
			String ff = sc1.nextLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		pw.write(idx + "\n");
		pw.flush();
		try {
			Scanner sc = new Scanner(s.getInputStream());
			String fromServer = sc.nextLine();
			File f = new File("page.html");
			FileOutputStream fos = new FileOutputStream(f);
			DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(fos));
			DataInputStream dis = new DataInputStream(s.getInputStream());
			for (int i = 0; i < Integer.parseInt(fromServer); i++) {
				byte b = (byte) dis.read();
				dos.writeByte(b);
				dos.flush();
			}
			dos.close();
			fos.close();
			String fromServer1 = sc.nextLine();
			FileOutputStream fos1 = new FileOutputStream("./z/" + fromServer1 + ".jpg");
			DataOutputStream dos1 = new DataOutputStream(new BufferedOutputStream(fos1));
			DataInputStream dis1 = new DataInputStream(s.getInputStream());
			String fromServer2 = sc.nextLine();
			byte[] b = new byte [Integer.parseInt(fromServer2)];
			for (int i = 0; i < b.length; i++) {
				b[i] = dis1.readByte();
			}
			for (int i = 0; i < b.length; i++) {
				dos1.writeByte(b[i]);
				dos1.flush();
			}
			dos1.close();
			fos1.close();
			
			StreamForLogs sfl = new StreamForLogs(s, "learn more");
			Thread t1 = new Thread(sfl);
			t1.start();
			try {
				uri = new URI(fromServer);
				open(uri);
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
			open(f.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void open(URI uri2){
		Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
		if(desktop != null && desktop.isSupported(Desktop.Action.BROWSE)){
			try {
				desktop.browse(uri2);
			} catch (IOException e) {
				//e.printStackTrace();
			}
		}
	}

}
