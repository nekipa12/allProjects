package edu.shag.lesson7.dz3;

public class Study 
{
	private String surname;
	private String name;
	
	public String getSurname() 
	{
		return surname;
	}
	public void setSurname(String surname) 
	{
		this.surname = surname;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public Study(String surname, String name) 
	{
		this.surname = surname;
		this.name = name;
		
	}
	
	@Override
	public String toString() 
	{
		return "surname= " + surname + ", name= " + name;
	}
}
