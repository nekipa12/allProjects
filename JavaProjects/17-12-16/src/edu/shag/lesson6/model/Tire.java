package edu.shag.lesson6.model;

public class Tire 
{
	//поля класса
	
	/**
	 * размер шин
	 */
	private double size;
	/**
	 * назначение шин...
	 * лучше сделать enum
	 */
	private String type;
	/**
	 * сезон
	 */
	private String season;
	
	/**
	 * качество
	 */
	private int quality;
	
	/**
	 * максимальная скорость
	 */
	private int maxSpeed;
	
	
	
	
	
	
	
	
	
	
	
	public String getType() 
	{
		return type;
	}







	public void setType(String type) 
	{
		this.type = type;
	}







	public String getSeason() 
	{
		return season;
	}







	public void setSeason(String season)
	{
		this.season = season;
	}







	public int getQuality() 
	{
		return quality;
	}







	public void setQuality(int quality) 
	{
		this.quality = quality;
	}







	public int getMaxSpeed() 
	{
		return maxSpeed;
	}







	public void setMaxSpeed(int maxSpeed) 
	{
		this.maxSpeed = maxSpeed;
	}






	//конструктор(ры)
	public Tire(double size, String type, String season, int quality, int maxSpeed)
	{
		this.size = size;//this ссылка на собственные поля и методы
		this.type = type;
		this.season = season;
		this.quality = quality;
		this.maxSpeed = maxSpeed;
	}
	
	
	
	
	
	
	
	//методы
	
	/**
	 * описание метода
	 * @param percent процент ремонта
	 */
	public void repair(int percent)
	{
		this.quality+=percent;
		chechquality();
	}
	
	
	public void ride ()
	{
		this.quality-=10;
		if(this.quality<0) this.quality=0;
	}
	
	
	public static void showTire()
	{
		System.out.println(" **");
		System.out.println("****");
		System.out.println("****");
		System.out.println(" **");
	}


	public void maxSpeed()
	{
		
		
	}
	
	
	private void chechquality()
	{
		if(this.quality>100) this.quality=100;
	}
	
	//ГЕТТЕР 
	public double getSize() // разрешение на чтение этого поля
	{
		return size;
	}
	// СЕТТЕР
	
	public void setSize(double size)
	{
		if (size>13) this.size=size;
	}
	
		
	
	
	
	
	@Override
	public String toString() 
	{
		return "Tire size=" + size + ", type=" + type + ", season=" + season
				+ ", quality=" + quality + ", maxSpeed=" + maxSpeed
				+ ", getType()=" + getType() + ", getSeason()=" + getSeason()
				+ ", getQuality()=" + getQuality() + ", getMaxSpeed()="
				+ getMaxSpeed() + ", getSize()=" + getSize() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}	

}
