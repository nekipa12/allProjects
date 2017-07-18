import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import org.omg.CORBA.portable.OutputStream;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ServerThreads implements Runnable {
	private Socket s;
	private Logs l;
	private int id;
	private ArrayList<String> al;
	
	public ServerThreads(Socket s, int id) {
		this.s = s;
		this.id = id;
	}

	@Override
	public void run() {
		while(true){
			Scanner scClientOrOperatorOrAdmin;
			try {
				scClientOrOperatorOrAdmin = new Scanner(s.getInputStream());
				String listner = scClientOrOperatorOrAdmin.nextLine();
				if(listner.equals("Client")){
					if(!Main.key.equals("0")){
						PrintWriter pw = new PrintWriter(s.getOutputStream());
						pw.write("no" + "\n");
						pw.flush();
						pw.write(Main.msg + "\n");
						pw.flush();
						return;
					}
					try {
						PrintWriter pww = new PrintWriter(s.getOutputStream());
						pww.write("ok" + "\n");
						pww.flush();
						while(true){
							Scanner sc = new Scanner(s.getInputStream());
							String fromClient = sc.nextLine();
							if(fromClient.equals("end")){
								break;
							}
							if(fromClient.equals("3939")){
								Scanner scGson = new Scanner(s.getInputStream());
								String fromClientGson = scGson.nextLine();
								Gson gson = new Gson();
								Type type = new TypeToken<ArrayList<String>>(){}.getType();
								al = new ArrayList<>();
								al = gson.fromJson(fromClientGson, type);
								PrintWriter pw = new PrintWriter(new FileOutputStream("./Orders/"+ al.get(1).toString() + " " + Integer.toString(id) + ".json"));
								pw.write(fromClientGson + "\n");
								pw.flush();
							}
							if(fromClient.equals("RegistrAndLog")){
								Scanner scReg = new Scanner(s.getInputStream());
								String fromJson = scReg.nextLine();
								l = new Logs(fromJson);
								Thread t = new Thread(l);
								t.start();
								ArrayList<String> alap = new ArrayList<>();
								for(AboutPizza ap : AboutPizza.pizza()){
									alap.add(ap.getName()+ " " + ap.getPrice() + " grn");
								}
								Gson gson = new Gson();
								String toGson = gson.toJson(alap);
								System.out.println(toGson);
								pww.write(toGson + "\n");
								pww.flush();
							}
							if(fromClient.equals("GetHTML")){
								pww.write("ok" + "\n");
								pww.flush();
								Scanner scReadIndex = new Scanner(s.getInputStream());
								int idx = scReadIndex.nextInt();
								FileInputStream fis = new FileInputStream(AboutPizza.pizza().get(idx).getF());
								DataInputStream dis = new DataInputStream(new BufferedInputStream(fis));
								pww.write(fis.available() + "\n");
								pww.flush();
								byte[] b = new byte [fis.available()];
								java.io.OutputStream dos = s.getOutputStream();
								for (int i = 0; i < b.length; i++) {
									b[i] = dis.readByte();
									dos.write(b[i]);
									dos.flush();
								}
								String m = AboutPizza.pizza().get(idx).getF().getName();
								String[] name = m.split("\\.");
								pww.write(name[0] + "\n");
								pww.flush();
								File f = new File("./z/" + name[0] + ".jpg");
								FileInputStream fis1 = new FileInputStream(f);
								DataInputStream dis1 = new DataInputStream(new BufferedInputStream(fis1));
								pww.write(fis1.available() + "\n");
								pww.flush();
								DataOutputStream dos1 = new DataOutputStream(s.getOutputStream());
								byte[] buff = new byte [fis1.available()];
								for (int i = 0; i < buff.length; i++) {
									buff[i] = dis1.readByte();
									
								}
								for (int i = 0; i < buff.length; i++) {
									dos1.write(buff[i]);
									dos1.flush();
								}
								
							}
							if(fromClient.equals("logs")){
								Scanner sclogs = new Scanner(s.getInputStream());
								String logsFromClient = sclogs.nextLine();
								l.writeInformatoin11(logsFromClient);
							}
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}else if(listner.equals("Operator")){
					if(!Main.key.equals("0")){
						PrintWriter pw = new PrintWriter(s.getOutputStream());
						pw.write("no" + "\n");
						pw.flush();
						pw.write(Main.msg + "\n");
						pw.flush();
						return;
					}
					ServerInThreads.clients.add(s);
					File f = new File("./Orders/");
					File [] files = f.listFiles();
					PrintWriter pw = new PrintWriter(s.getOutputStream());
					ArrayList<String> al = new ArrayList<>();
					for (int i = 0; i < files.length; i++) {
						Scanner scReadGson = new Scanner(new FileInputStream(files[i]));
						String gson = scReadGson.nextLine();
						al.add(gson);
					}
					Gson g = new Gson();
					String str = g.toJson(al);
					pw.write(str + "\n");
					pw.flush(); 
					
					while(true) {
						Scanner scOperator = new Scanner(s.getInputStream());
						String info2 = scOperator.nextLine();
						if(info2.equals("end")){
							ServerInThreads.clients.remove(s);
							pw.write("end" + "\n");
							pw.flush();
							break;
						}else {
							for(Socket ss : ServerInThreads.clients){
								PrintWriter pw1 = new PrintWriter(ss.getOutputStream());
								pw1.write(info2 + "\n");
								pw1.flush();
							}
						}
					}
				}else if(listner.equals("Admin")){
					System.out.println(listner);
					PrintWriter pw = new PrintWriter(s.getOutputStream());
					pw.write("f" + "\n");
					pw.flush();
					Scanner scAdmin = new Scanner(s.getInputStream());
					String from = scAdmin.nextLine();
					Main.msg = from;
					System.out.println(from);
					from = scAdmin.nextLine();
					Main.key = from;
					System.out.println(from);
				}
				break;
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}
		
	}

}
