package edu.shag.lesson7.model;

class Point 
{
	protected int X;
	protected int Y;
	
	

	public Point(int X, int Y) 
	{
		this.X = X;
		this.Y = Y;
	}
	
	
	
	public Point(){ X=0; Y=0;}

	
	
	public int getX() 
	{
		return X;
	}
	public void setX(int X) 
	{
		this.X = X;
	}
	public int getY() 
	{
		return Y;
	}
	public void setY(int Y) 
	{
		this.Y = Y;
	}
	
	
	
	void move(int incX, int incY )
	{
		X+=incX;
		Y+=incY;
	}



	@Override
	public String toString() 
	{
		return "Point [X=" + X + ", Y=" + Y + "]";
	}
	
	
	




}
