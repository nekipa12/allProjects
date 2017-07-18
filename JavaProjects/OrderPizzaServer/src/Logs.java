import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Logs implements Runnable{

	private Gson gson;
	private String fromJson;
	private ArrayList<String> al;
	private File f;
	private Date d;
	private int iterator = 0;
	
	public ArrayList<String> getAl() {
		return al;
	}


	public Logs(String fromJson) {
		this.fromJson = fromJson;
		d = new Date();
		al = new ArrayList<>();
		gson = new Gson();
	}


	@Override
	public void run() {
		Type type = new TypeToken<ArrayList<String>>(){}.getType();
		al = gson.fromJson(fromJson, type);
		if(iterator == 0){
			createNewLogs();
			iterator++;
		}
		writeInformatoin();
	}


	private void writeInformatoin() {
		FileWriter fw;
		try {
			fw = new FileWriter(f);
			String h = d.toString();
			fw.write(h + fromJson + "\n");
			fw.flush();
			//fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	public void writeInformatoin11(String g) {
		FileWriter fw;
		try {
			fw = new FileWriter(f , true);
			String h = d.toString();
			fw.write(h + g + "\n");
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	private void createNewLogs() {
		String g = getAl().get(1);
		f = new File("./Clients/" + g + ".txt");
		try {
			f.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
