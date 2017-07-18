package edu.shag.lesson7.dz;

import java.util.Scanner;

public class PassportParent 
{	/**
	*фамилия
	*/
	private String surname;
	/**
	 * имя
	 */
	private String givenNames;
	/**
	 * дата рождения
	 */
	private String dateOfBirth;
	/**
	 * место рождения
	 */
	private String placeOfBirth;
	/**
	 * орган который выдал паспорт
	 */
	private String authority;
	/**
	 * дата выдачи паспорта
	 */
	private String dateOfIssue;
	/**
	 * серия паспорта
	 */
	private String passportSeries;
	/**
	 * номер паспорта
	 */
	private String passportNo;
	
	public String getSurname() 
	{
		return surname;
	}
	public void setSurname(String surname) 
	{
		this.surname = surname;
	}
	public String getGivenNames() 
	{
		return givenNames;
	}
	public void setGivenNames(String givenNames) 
	{
		this.givenNames = givenNames;
	}
	public String getDateOfBirth() 
	{
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) 
	{
		this.dateOfBirth = dateOfBirth;
	}
	public String getPlaceOfBirth() 
	{
		return placeOfBirth;
	}
	public void setPlaceOfBirth(String placeOfBirth) 
	{
		this.placeOfBirth = placeOfBirth;
	}
	public String getAuthority() 
	{
		return authority;
	}
	public void setAuthority(String authority) 
	{
		this.authority = authority;
	}
	public String getDateOfIssue() 
	{
		return dateOfIssue;
	}
	public void setDateOfIssue(String dateOfIssue) 
	{
		this.dateOfIssue = dateOfIssue;
	}
	public String getPassportSeries() 
	{
		return passportSeries;
	}
	public void setPassportSeries(String passportSeries) 
	{
		this.passportSeries = passportSeries;
	}
	public String getPassportNo() 
	{
		return passportNo;
	}
	public void setPassportNo(String passportNo) 
	{
		this.passportNo = passportNo;
	}

	
	@Override
	public String toString() 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("input surname");
		this.surname = sc.nextLine();
		System.out.println("input given names");
		this.givenNames = sc.nextLine();
		System.out.println("input date of birth");
		this.dateOfBirth = sc.nextLine();
		System.out.println("input place of birth");
		this.placeOfBirth = sc.nextLine();
		System.out.println("input authority");
		this.authority = sc.nextLine();
		System.out.println("input date of issue");
		this.dateOfIssue = sc.nextLine();
		System.out.println("input passport series");
		this.passportSeries = sc.nextLine();
		System.out.println("input passport No");
		this.passportNo = sc.nextLine();
		
		return "surname=" + surname + ", givenNames=" + givenNames + ", dateOfBirth=" + dateOfBirth
				+ ", placeOfBirth=" + placeOfBirth + ", authority=" + authority + ", dateOfIssue=" + dateOfIssue
				+ ", passportSeries=" + passportSeries + ", passportNo=" + passportNo + "";
	}
}
