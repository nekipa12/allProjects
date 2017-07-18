package edu.shag.lesson15.fileManagerInThreads.model;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class CopyTh implements Runnable {
	private String path;
	private String name;
	
	
	public CopyTh(String path, String name) {
		this.path = path;
		this.name = name;
	}


	


	@Override
	public void run() {
		InputStream is = null;
		OutputStream os = null;
		try{
			try {
				is = new FileInputStream(path);
				os = new FileOutputStream("./z/" + name);
				
			} catch (FileNotFoundException e) {
				System.out.println("файл не найден или неверно введен путь");
			}
			byte [] buffer = new byte [5024];
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
				//sc.close();
			} catch (IOException e) {
			}
		}
	}
	
	

}
