package edu.shag.lesson7.dz;

import java.util.Scanner;

public class InternationalPassport extends PassportParent
{	/**
	*национальность
	*/
	private String nationality;
	/**
	 * срок годности
	 */
	private String dateOfExpiry;
	
	public String getNationality() 
	{
		return nationality;
	}
	public void setNationality(String nationality) 
	{
		this.nationality = nationality;
	}
	public String getDateOfExpiry() 
	{
		return dateOfExpiry;
	}
	public void setDateOfExpiry(String dateOfExpiry) 
	{
		this.dateOfExpiry = dateOfExpiry;
	}
	
	public InternationalPassport() 
	{
		
	
	}
	
	@Override
	public String toString() 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("input nationality");
		this.nationality = sc.nextLine();
		System.out.println("input date of expiry");
		this.dateOfExpiry = sc.nextLine();
		//sc.close();
		return "InternationalPassport "+super.toString()+" nationality= " + nationality + ", dateOfExpiry= " + dateOfExpiry + "";
	}
}
