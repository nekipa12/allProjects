import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import com.google.gson.Gson;

public class SendToServer implements Runnable{
	private ArrayList<String> info;
	private ArrayList<String> arr;
	private PrintWriter pw;
	private Socket s;
	public SendToServer(ArrayList<String> info, ArrayList<String> arr, Socket s) {
		this.info = new ArrayList<>();
		this.arr = new ArrayList<>();
		this.arr = arr;
		this.info = info;
	}

	@Override
	public void run() {
		try {
			for(String s : arr){
				info.add(s);
			}
			pw = new PrintWriter(Client.s.getOutputStream());
			pw.write("3939" + "\n");
			pw.flush();
			Gson gson = new Gson();
			String toServer = gson.toJson(info);
			pw.write(toServer + "\n");
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
