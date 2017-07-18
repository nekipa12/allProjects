package edu.shag.leeson13.store;

public abstract class PhoneTabletParent {
	/**
 	* �������������
 	*/
	private String manufacturer;
	/**
	 * ����
	 */
	private int price;
	/**
	 * ������ ������
	 */
	private double inch;
	/**
	 * ������������ �������
	 */
	private String os;
	/**
	 * ����� ����������� ������
	 */
	private int ram;
	/**
	 * ����� �������
	 */
	private int battary;
	/**
	 * �-�� ������������ ������
	 */
	private int camera;
	/**
	 * �-�� ����
	 */
	private int core;
	/**
	 * ��������
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
