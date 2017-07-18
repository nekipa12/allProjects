package edu.shag.lesson7.model;

class Line extends Point implements Drawable, Shortable 
{

	private int X2;
	private int Y2;
	private double distance;
	
	
	public Line(int X, int Y, int X2, int Y2) 
	{
		super(X, Y);//вызов конструктора родителя и должен быть первой строчкой конструктора
		this.X2 = X2;
		this.Y2 = Y2;
	}



	public int getX2() 
	{
		return X2;
	}
	public void setX2(int X2) 
	{
		this.X2 = X2;
	}
	public int getY2() 
	{
		return Y2;
	}
	public void setY2(int Y2) 
	{
		this.Y2 = Y2;
	}



	void move(int incX, int incY, int incX2, int incY2) 
	{
		super.move(incX, incY);
		X2+=incX2;
		Y2+=incY2;
	}

	
	
	
	
	
	 double getDistance() 
	{
		 distance = Math.sqrt((X2-getX())*(X2-getX())+
				 (Y2-getY())*(Y2-getY()));
		 return distance;
	}



	@Override
	public String toString() 
	{
		return "Line ["+super.toString()+"X2=" + X2 + ", Y2=" + Y2 + "]";
	}



	@Override
	public void makeShort() 
	{
		//setX((int)(getX()*0.9));// если протектед то эти ф-ции нам не нужны
		//setY((int)(getY()*0.9));
		X*=0.9;//без протектеда, обращение напрямую(в случае если класс в наследниках)
		Y*=0.9;
		X2*=0.9;
		Y2*=0.9;
		
	}



	@Override
	public void drawStars() 
	{
		int dist = (int) getDistance();
		for(int i=0; i<dist; i++)
		{
			System.out.print("*");
		}
		System.out.println();
	}



	@Override// означает проверить есть ли в родительском классе или интерфейсе место с таким именем и сигнатурой0
	public void drawDots() 
	{
		int dist = (int) getDistance();
		for(int i=0; i<dist; i++)
		{
			System.out.print(".");
		}
		System.out.println();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
