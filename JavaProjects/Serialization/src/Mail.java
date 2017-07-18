import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class Mail {

	/*public static void main(String[] args) {
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("./fraction.dat")));
			Test t = new Test(5, 7);
			Fraction f = new Fraction(1, 2, t);
			oos.writeObject(f);
			oos.flush();
			oos.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}*/
		

		/*ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("./fraction.dat")));
			
			Fraction f2 = null;
			try {
				f2 = (Fraction)ois.readObject();
				System.out.println(f2);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}*/
	
	public static void main(String[] args) {
		
		Gson gson = new Gson();
		Test t = new Test(15, 17);
		Fraction f = new Fraction(3, 4, t);
		String JSON = gson.toJson(f);
		System.out.println(JSON);
		PrintWriter pw;
		try {
			pw = new PrintWriter(new FileOutputStream("./Fraction.json"));
			pw.write(JSON);
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Scanner sc; 
		Gson gson2 = new Gson();
		try {
			sc = new Scanner(new FileInputStream("./Fraction.json"));
			String res = sc.nextLine();
			Fraction f2 = gson2.fromJson(res, Fraction.class);
			System.out.println(f2);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		/*ArrayList<Integer> aL = new ArrayList<>();
		Gson gson = new Gson();
		for(int i = 0; i < 10; i++){
			aL.add(i);
		}
		String toJson = gson.toJson(aL);
		System.out.println(toJson);
		ArrayList<Integer> aL2;
		Type type = new TypeToken<ArrayList<Integer>>(){}.getType();
		aL2 = gson.fromJson(toJson, type);
		for (Integer i : aL2){
			System.out.println(i);
		}*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
