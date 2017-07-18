package edu.shag.leeson13.store;

public class Phone extends PhoneTabletParent
{	/**
	*сканнер отпечатков пальцев
	*/
	private String fingerprintScanner;

	public String getFingerprintScanner() 
	{
		return fingerprintScanner;
	}
	public void setFingerprintScanner(String fingerprintScanner) 
	{
		this.fingerprintScanner = fingerprintScanner;
	}

	
	public Phone(String manufacturer, int price, double inch, String os, int ram, int battary, int camera,
			int core, int iD, String fingerprintScanner) 
	{
		super(manufacturer, price, inch, os, ram, battary, camera, core, iD);
		this.fingerprintScanner = fingerprintScanner;
	}

	
	@Override
	public String toString() 
	{
		return "Phone "+super.toString()+"fingerprintScanner=" + fingerprintScanner + "]";
	}
}
