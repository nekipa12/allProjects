import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Client {
	private ArrayList<String> g = new ArrayList<>();
	public static Socket s;
	private PrintWriter pw;
	private ArrayList<String> pizzaNames;
	private JFrame f;
	
	public Socket getS() {
		return s;
	}
	public Client(ArrayList<String> go) {
		this.g= go;
		pizzaNames = new ArrayList<>();
	}
	public Client(ArrayList<String> g2, JFrame frame) {
		this.f = frame;
		pizzaNames = new ArrayList<>();
	}
	public void start(){
		connect();
		try {
			pw = new PrintWriter(s.getOutputStream());
			pw.write("Client" + "\n");
			pw.flush();
			Scanner sc = new Scanner(s.getInputStream());
			String ok = sc.nextLine();
			if(ok.equals("no")){
				ok = sc.nextLine();
				JOptionPane.showMessageDialog(null, ok);
				f.dispose();
				s.close();
				return;
			}
			pw.write("RegistrAndLog" + "\n");
			pw.flush();
			Gson gson = new Gson();
			String toGson = gson.toJson(g);
			pw.write(toGson + "\n");
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		try {
			Scanner sc = new Scanner(s.getInputStream());
			String fromServer = sc.nextLine();
			Gson gson = new Gson();
			Type type = new TypeToken<ArrayList<String>>(){}.getType();
			pizzaNames = gson.fromJson(fromServer, type);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void addName(JComboBox comboBox){
		for(String t : pizzaNames){
			comboBox.addItem(t);
		}
	}
	public void connect(){
		try {
			s = new Socket("localhost", 63521);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
