package edu.shag.rmiServer;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;

import edu.shag.lib.Calc;


public class Server {
	public static void main(String [] args) throws RemoteException {
		Scanner sc = new Scanner(System.in);
		System.out.println("input currency");
		double currency = sc.nextDouble();
		Calc aCalc;
		try {
			aCalc = new CalcImpl(currency);
			Naming.rebind("rmi://localhost/CalcService", aCalc);
		} catch (RemoteException e) {
			e.printStackTrace();
		}catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
	}
}
