package edu.shag.lesson16.seaBattleClient.model;

import java.util.ArrayList;

public class Ship {
	
	private String name;
	private ArrayList<String> location;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<String> getLocation() {
		return location;
	}
	public void setLocation(ArrayList<String> loc) {
		location = loc;
	}
	public Ship(String name) {
		
		this.name = name;
		this.location = location;
	}
	public Ship() {
		
		this.name = name;
		this.location = location;
	}	
}
