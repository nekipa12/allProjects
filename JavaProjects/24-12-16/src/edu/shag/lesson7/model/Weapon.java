package edu.shag.lesson7.model;

public abstract class Weapon 
{
	protected double damage;
	protected int ammo;
	protected int currentAmmo;
	
	
	
	public double getDamage() 
	{
		return damage;
	}
	public void setDamage(double damage) 
	{
		this.damage = damage;
	}
	public int getAmmo() 
	{
		return ammo;
	}
	public void setAmmo(int ammo) 
	{
		this.ammo = ammo;
	}
	public int getCurrentAmmo() 
	{
		return currentAmmo;
	}
	public void setCurrentAmmo(int currentAmmo) 
	{
		this.currentAmmo = currentAmmo;
	}
	
	
	
	
	public Weapon(double damage, int ammo, int currentAmmo) 
	{
		this.damage = damage;
		this.ammo = ammo;
		this.currentAmmo = currentAmmo;
	}
	
	
	
	public abstract void shoot();//метод без реализации... только в абстрактном классе
	
	public abstract void reload();
	
	//public abstract void superShoot(); 
	
	
	
	
	
	
	
	
	
	
	
}
