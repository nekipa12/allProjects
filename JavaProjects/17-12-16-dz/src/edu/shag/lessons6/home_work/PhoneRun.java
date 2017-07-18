package edu.shag.lessons6.home_work;

public class PhoneRun 
{
	public static void main(String[] args) 
	{
		Phone g = new Phone(100, 0, "ДИНЬ-ДИНЬ", null, 11.0, args, null, "Нужно срочно совершить звонок");
		g.onPhone();
	}
}
