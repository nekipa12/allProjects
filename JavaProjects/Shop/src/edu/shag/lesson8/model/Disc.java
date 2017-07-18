package edu.shag.lesson8.model;

public class Disc extends Staff
{
	private int capacity;
	private String writeFormat;
	
	
	
	
	public int getCapacity() 
	{
		return capacity;
	}
	public void setCapacity(int capacity) 
	{
		this.capacity = capacity;
	}
	public String getWriteFormat() 
	{
		return writeFormat;
	}
	public void setWriteFormat(String writeFormat) 
	{
		this.writeFormat = writeFormat;
	}
	
	
	
	
	
	public Disc(double price, String name, String manufacturer, int capacity, String writeFormat) 
	{
		super(price, name, manufacturer);
		this.capacity = capacity;
		this.writeFormat = writeFormat;
	}
	
	
	
	
	@Override
	public void buy() 
	{
		System.out.println("You buy disc:" + toString());
		
	}
	@Override
	public void byOnCredit() 
	{
		System.out.println("You buy disc : " + toString() + " on credit");
		
	}
	@Override
	public String toString() 
	{
		return "Disc ["+super.toString()+"capacity=" + capacity + ", writeFormat=" + writeFormat+ "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
