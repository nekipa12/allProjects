package edu.shag.leeson13.store;


public class Tablet extends PhoneTabletParent
{	/**
	*три джи
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
			int core, int iD, String sim3g) 
	{
		super(manufacturer, price, inch, os, ram, battary, camera, core, iD);
		sim3G = sim3g;
	}
	
	@Override
	public String toString() 
	{
		return "Tablet "+super.toString()+"sim3G=" + sim3G;
	}
}	