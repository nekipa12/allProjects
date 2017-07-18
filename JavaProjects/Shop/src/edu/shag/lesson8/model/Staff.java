package edu.shag.lesson8.model;

public abstract class Staff implements Comparable<Staff>
{
	private double price;
	private String name;
	private String manufacturer;
	
	
	
	public double getPrice() 
	{
		return price;
	}
	public void setPrice(double price) 
	{
		this.price = price;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getManufacturer() 
	{
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) 
	{
		this.manufacturer = manufacturer;
	}
	
	
	
	public Staff(double price, String name, String manufacturer) 
	{
		this.price = price;
		this.name = name;
		this.manufacturer = manufacturer;
	}
	
	
	public abstract void buy();
	
	public abstract void byOnCredit();
	
	
	
	@Override
	public int compareTo(Staff obj) 
	{
		if(this.price>obj.getPrice())return 1;
		else if(this.price<obj.getPrice())return -1;
		else return 0;
	}
	
	@Override
	public String toString() 
	{
		return "Staff [price=" + price + ", name=" + name + ", manufacturer="
				+ manufacturer + "]";
	}
	
	
	
	
	
	
	
	
	

	


	
}
