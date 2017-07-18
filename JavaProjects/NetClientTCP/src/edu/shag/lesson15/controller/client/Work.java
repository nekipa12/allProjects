package edu.shag.lesson15.controller.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edu.shag.lesson15.model.client.NetModel;
import edu.shag.lesson15.view.client.ViewClient;

public class Work {
	private NetModel nm;
	private PrintWriter pw;
	private Scanner sc;
	private String toServer;
	private Scanner keyboard;
	private ViewClient vc;

	public Work() {
		nm = new NetModel("127.0.0.1", 5916);
		vc = new ViewClient();
	}

	public void start() {
		use();
		keyboard = new Scanner(System.in);
		while (true){
			try {
				pw = new PrintWriter(nm.getS().getOutputStream());
				sc = new Scanner(nm.getS().getInputStream());
				
				toServer = keyboard.nextLine();
				if(toServer.equals(vc.end())){
					writeFlush("##!@");
					nm.getS().close();
					sc.close();
					keyboard.close();
					pw.close();
					break;
				}
				if(toServer.equals("dir")){
					writeFlush(toServer + "\n");
					Gson gson = new Gson();
					String fromJson = sc.nextLine();
					ArrayList<String> al = new ArrayList<>();
					Type type = new TypeToken<ArrayList<String>>(){}.getType();
					al = gson.fromJson(fromJson, type);
					int it = 0;
					for(String str : al) {
						vc.methArray(it, str);
						it++;
					}
				}
				writeFlush(toServer);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			nm.getS().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sc.close();
		keyboard.close();
		pw.close();
	}

	private void use() {
		vc.use();
	}

	private void writeFlush(String string) {
		pw.write(string + "\n");
		pw.flush();
	}
}
