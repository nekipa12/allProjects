package edu.shag.lesson7.model;

public class Bazooka extends Weapon
{
	public Bazooka(double damage, int ammo, int currentAmmo) 
	{
		super(damage, ammo, currentAmmo);
	}

	@Override
	public void shoot() 
	{
		System.out.println("Bazooka boooooom");
		ammo--;
	}

	@Override
	public void reload() 
	{
		System.out.println("Bazooka reload");
	}

	public void shoot4() 
	{
		System.out.println("Realy big boooooom");
	}




}
