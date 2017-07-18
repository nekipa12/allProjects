package edu.shag.leeson13.store;

public abstract class PhoneTabletParent {
	/**
 	* производитель
 	*/
	private String manufacturer;
	/**
	 * цена
	 */
	private int price;
	/**
	 * размер экрана
	 */
	private double inch;
	/**
	 * операционная система
	 */
	private String os;
	/**
	 * объем оперативной памяти
	 */
	private int ram;
	/**
	 * объем батареи
	 */
	private int battary;
	/**
	 * к-во мегапикселей камеры
	 */
	private int camera;
	/**
	 * к-во ядер
	 */
	private int core;
	/**
	 * айдишник
	 */
	private int iD;
	
	public int getiD() {
		return iD;
	}
	public String getManufacturer() 
	{
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) 
	{
		this.manufacturer = manufacturer;
	}
	public int getPrice() 
	{
		return price;
	}
	public void setPrice(int price) 
	{
		this.price = price;
	}
	public double getInch() 
	{
		return inch;
	}
	public void setInch(double inch) 
	{
		this.inch = inch;
	}
	public String getOs() 
	{
		return os;
	}
	public void setOs(String os) 
	{
		this.os = os;
	}
	public int getRam() 
	{
		return ram;
	}
	public void setRam(int ram) 
	{
		this.ram = ram;
	}
	public int getBattary() 
	{
		return battary;
	}
	public void setBattary(int battary) 
	{
		this.battary = battary;
	}
	public int getCamera() 
	{
		return camera;
	}
	public void setCamera(int camera) 
	{
		this.camera = camera;
	}
	public int getCore() 
	{
		return core;
	}
	public void setCore(int core) 
	{
		this.core = core;
	}
	
	public PhoneTabletParent(String manufacturer, int price, double inch, String os, int ram, int battary,
			int camera, int core, int iD) 
	{
		this.manufacturer = manufacturer;
		this.price = price;
		this.inch = inch;
		this.os = os;
		this.ram = ram;
		this.battary = battary;
		this.camera = camera;
		this.core = core;
		this.iD = iD;
	}
	
	@Override
	public String toString() 
	{
		return "manufacturer=" + manufacturer + ", price=" + price + ", inch=" + inch + ", os=" + os
				+ ", ram=" + ram + ", battary=" + battary + ", camera=" + camera + ", core=" + core+", iD" + iD;
	}
}
