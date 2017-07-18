package edu.shag.lesson7.dz2;

public class Phone extends PhoneTabletParent
{	/**
	*������� ���������� �������
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
			int core, String fingerprintScanner) 
	{
		super(manufacturer, price, inch, os, ram, battary, camera, core);
		this.fingerprintScanner = fingerprintScanner;
	}

	
	@Override
	public String toString() 
	{
		return "Phone "+super.toString()+"fingerprintScanner=" + fingerprintScanner + "]";
	}
	
	
	
	
}
