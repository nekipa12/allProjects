import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Operator {
	public static Socket s;
	private PrintWriter pw;
	private Scanner sc;
	public static ArrayList<String> gson;
	
	
	public ArrayList<String> getGson() {
		return gson;
	}
	public Socket getS() {
		return s;
	}
	public Operator() {
		try {
			s = new Socket("localhost", 63521);
			sc = new Scanner(s.getInputStream());
			pw = new PrintWriter(s.getOutputStream());
			gson = new ArrayList<>();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void start(){
		keySend();
		getInfo();
		ListenerThread lt = new ListenerThread(s);
		Thread t = new Thread(lt);
		t.start();
	}
	
	private void getInfo() {
		String g = sc.nextLine();
		if(g.equals("no")){
			g = sc.nextLine();
			JOptionPane.showMessageDialog(null, g);
			return;
		}
		Gson json = new Gson();
		Type type = new TypeToken<ArrayList<String>>(){}.getType();
		gson = json.fromJson(g, type);
		
		
	}
	private void keySend() {
		pw.write("Operator" + "\n");
		pw.flush();
		
	}
}
