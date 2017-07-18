package edu.shag.lesson8.model;

public class Apple extends Staff
{
	private String color;
	private String grade;
	
	
	
	public String getColor() 
	{
		return color;
	}
	public void setColor(String color) 
	{
		this.color = color;
	}
	public String getGrade() 
	{
		return grade;
	}
	public void setGrade(String grade) 
	{
		this.grade = grade;
	}
	
	
	
	
	public Apple(double price, String name, String manufacturer, String color, String grade) 
	{
		super(price, name, manufacturer);
		this.color = color;
		this.grade = grade;
	}
	
	
	
	@Override
	public void buy() 
	{
		System.out.println("You buy apple: " + toString());
	}
	@Override
	public void byOnCredit() 
	{
		System.out.println("We don`t sell apples on credit");
	}
	@Override
	public String toString() {
		return "Apple ["+super.toString()+"color=" + color + ", grade=" + grade + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
