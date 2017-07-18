package edu.shag.lesson6.model;

public class Silo 
{
	/**
	 * вместимость
	 */
	private int capacity;
	
	/**
	 * место которое осталось в складе
	 */
	private int usedCapacity;
	private Tire[] tires;//агрегирование- экземпл€р(массив) класса становитс€ полем другого класса
	
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getUsedCapacity() {
		return usedCapacity;
	}






	public void setUsedCapacity(int usedCapacity) {
		this.usedCapacity = usedCapacity;
	}






	public Tire[] getTires() {
		return tires;
	}






	public void setTires(Tire[] tires) 
{
		this.tires = tires;
	}






	public Silo(int capacity, int usedCapacity, Tire[] tires) 
	{
		this.capacity = capacity;
		this.usedCapacity = 0;
		this.tires = new Tire[this.capacity];
	}
	
	
	
	
	

	public void addTire(Tire aTire)
	{
		if(usedCapacity < capacity) tires[usedCapacity++] = aTire;
	}
	
	Tire getTire(int num)
	{
		if(num<usedCapacity) return tires[num];
		return null;
	}
	
	Tire getTire(double size, String type, String season, int quality, int maxSpeed)
	{
		for (int i=0; i<tires.length; i++)
		{
			if(tires[i].getSize()==size && 
			tires[i].getType().equals(type) &&
			tires[i].getSeason().equals(season)) 
			return tires[i];
			
		}
		return null;
	}
	
	
	
	
	
	
	
	
	

}
