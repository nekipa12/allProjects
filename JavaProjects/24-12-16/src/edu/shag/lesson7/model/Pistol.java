package edu.shag.lesson7.model;

public class Pistol extends Weapon
{
	
	

	public Pistol(double damage, int ammo, int currentAmmo) 
	{
		super(damage, ammo, currentAmmo);
	}

	@Override
	public void shoot() 
	{
		System.out.println("Pistols shoot");
		ammo--;
	}

	@Override
	public void reload() 
	{
		System.out.println("Pistol reload");
	}
	public void shoot4() 
	{
		System.out.println("Realy big boooooom");
	}
}
