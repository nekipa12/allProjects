package edu.shag.lesson7.dz3;

public class Absolvent extends Study 
{	
	private int number;

	public int getNumber() 
	{
		return number;
	}
	public void setNumber(int number) 
	{
		this.number = number;
	}

	public Absolvent(String surname, String name, int number) 
	{
		super(surname, name);
		this.number = number;
	}

	@Override
	public String toString() 
	{
		return super.toString()+", number= " + number;
	}
}
