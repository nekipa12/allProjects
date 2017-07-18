package edu.shag.lesson14.stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.ietf.jgss.Oid;

public class StreamEdu {

	public static void main(String[] args) {
		/*FileOutputStream fos = null;
		PrintWriter pw = null;
		try {
			 fos = new FileOutputStream("./file2.txt", true);чтобы дописать нужно написать тру, чтобы удалить фолс
			 pw = new PrintWriter(new BufferedOutputStream(fos));
			 
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		String str = "hello";
		long t1 = System.currentTimeMillis(); // считает время выполнения программы
		for(int i= 0; i <100000; i++){
			pw.write(str + "\r\n" + "world!!!!!!!!!!!");
		}
		pw.flush();//сброс из буфера на устройство
		pw.close();
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1 + "ms");*/
		
		
		
		/*FileInputStream fis = null;
		Scanner sc = null;
		try {
			fis = new FileInputStream("./file2.txt");//аbсолютный не рекомендованый к использованию (С:\\hello.txt)
			sc = new Scanner(fis);					// относительный (./folder/folder/ file.txt)
			StringBuilder sb = new StringBuilder();
			while(sc.hasNextLine()){
				sb.append(sc.nextLine()+ "\n");
				//String s1 = sc.nextLine();
				//String s = sc.next();//token применяется для показа инфы пока не встретит разделительный файл
				
			}
			System.out.println(sb.toString());
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		//читаем файл который находится в проэкте											   
		sc.close();*/

		
		//в бинарном режиме
		/*DataOutputStream dos = null;
		FileOutputStream fos = null;
		try{
			
			fos =new FileOutputStream("./binary.dat");
			dos = new DataOutputStream(new BufferedOutputStream(fos));
			long t1 = System.currentTimeMillis(); 
			for(int i= 0; i <100000; i++){
				dos.writeInt(i);
			}
			for(int i= 0; i <100000; i++){
				//for(int j= 0; j <255; j++){
				dos.writeInt(i);
				//}
			}
			
			long t2 = System.currentTimeMillis();
			System.out.println(t2 - t1 + "ms");
		}catch(IOException e){
			e.printStackTrace();
		}*/
		
		/*DataInputStream dis = null;
		FileInputStream fis = null;
		try{
			
			fis =new FileInputStream("./binary.dat");
			dis = new DataInputStream(new BufferedInputStream(fis));
			ArrayList<Integer> aL = new ArrayList<>();
			for(int i= 0; i <100000; i++){
				aL.add(dis.readInt());
			}
			dis.close();
			System.out.println(aL.get(0) + " " + aL.get(100));
		}catch(IOException e){
			e.printStackTrace();
		}*/
		
		
		
		
		
		
		
		
		
		
	}

}
