package edu.shag.lesson7.dz2;

public class Tablet extends PhoneTabletParent
{	/**
	*��� ���
	*/
	private String sim3G;
	
	public String getSim3G() 
	{
		return sim3G;
	}
	public void setSim3G(String sim3g) 
	{
		sim3G = sim3g;
	}
	
	public Tablet(String manufacturer, int price, double inch, String os, int ram, int battary, int camera,
			int core, String sim3g) 
	{
		super(manufacturer, price, inch, os, ram, battary, camera, core);
		sim3G = sim3g;
	}
	
	@Override
	public String toString() 
	{
		return "Tablet "+super.toString()+"sim3G=" + sim3G;
	}
}	
	
	
	
	
	
	
	
	
	

