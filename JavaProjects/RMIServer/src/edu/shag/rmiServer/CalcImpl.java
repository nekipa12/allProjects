package edu.shag.rmiServer;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import edu.shag.lib.Calc;


public class CalcImpl extends UnicastRemoteObject implements Calc{
	

	private double currency;

	

	public CalcImpl(double currency) throws RemoteException
	{
		super();
		this.currency = currency;
	}



	@Override
	public double USDtoUAH(int amount) throws RemoteException {
		return currency*amount;
	}



	@Override
	public double UAHtoUSD(int amount) throws RemoteException {
		return amount/currency;
	}
	
	

	

}
