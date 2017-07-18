package edu.shag.lesson16.seaBattleServer.controller;

import java.util.ArrayList;

import java.util.Scanner;

import edu.shag.lesson16.seaBattleServer.model.Direction;
import edu.shag.lesson16.seaBattleServer.model.Ship;
import edu.shag.lesson16.seaBattleServer.view.ViewBattlePlace;

public class BattlePlace {
	
	private ArrayList<Ship> als;
	private Direction dir;
	private MakeCoordinats mc;
	private ViewBattlePlace vbp;
	
	
	
	public ArrayList<Ship> getAls() {
		return als;
	}
	public BattlePlace() {
		
		als = new ArrayList<>();
		mc = new MakeCoordinats();
		vbp = new ViewBattlePlace();
	}
	public void startMe(){
		als.add(new Ship("One"));
		als.add(new Ship("One"));
		als.add(new Ship("One"));
		als.add(new Ship("One"));
		als.add(new Ship("Two"));
		als.add(new Ship("Two"));
		als.add(new Ship("Two"));
		als.add(new Ship("Three"));
		als.add(new Ship("Three"));
		als.add(new Ship("Four"));
		Scanner sc = new Scanner(System.in);
		for(Ship ship : als){
			vbp.input(ship.getName());
			vbp.getMapOpponents();
			if(ship.getName().equals("One")){
				ArrayList<String> loc = new ArrayList<>();
				loc.add(sc.nextLine());
				ship.setLocation(loc);
			}else if(ship.getName().equals("Two")){
				ArrayList<String> loc = new ArrayList<>();
				loc.add(sc.nextLine());
				loc.add(sc.nextLine());
				ship.setLocation(loc);
			}else if(ship.getName().equals("Three")){
				ArrayList<String> loc = new ArrayList<>();
				loc.add(sc.nextLine());
				loc.add(sc.nextLine());
				loc.add(sc.nextLine());
				ship.setLocation(loc);
			}else if(ship.getName().equals("Four")){
				ArrayList<String> loc = new ArrayList<>();
				loc.add(sc.nextLine());
				loc.add(sc.nextLine());
				loc.add(sc.nextLine());
				loc.add(sc.nextLine());
				ship.setLocation(loc);
			}
			
		}
		vbp.getMapMe(als);
	}
	public void start(){
		
		
		als.add(new Ship("One"));
		als.add(new Ship("One"));
		als.add(new Ship("One"));
		als.add(new Ship("One"));
		als.add(new Ship("Two"));
		als.add(new Ship("Two"));
		als.add(new Ship("Two"));
		als.add(new Ship("Three"));
		als.add(new Ship("Three"));
		als.add(new Ship("Four"));
		
		for(Ship ship : als){
			if(ship.getName().equals("One")){
				ArrayList<String> loc = mc.makeAdress(1);
				ship.setLocation(loc);
			}else if(ship.getName().equals("Two")){
				ArrayList<String> loc = mc.makeAdress(2);
				ship.setLocation(loc);
			}else if(ship.getName().equals("Three")){
				ArrayList<String> loc = mc.makeAdress(3);
				ship.setLocation(loc);
			}else if(ship.getName().equals("Four")){
				ArrayList<String> loc = mc.makeAdress(4);
				ship.setLocation(loc);
			}
		}
		
	}
	public String check(String fromClient) {
		for(Ship p : als){
			for(int i = 0; i < p.getLocation().size(); i++){
				if(p.getLocation().get(i).equals(fromClient)){
					return "попал";
				} 
			}
		}
		return "мимо";
	}
	public String remove(String fromClient) {
		
		for(Ship p : als){
			for(int i = 0; i < p.getLocation().size(); i++){
				if(p.getLocation().get(i).equals(fromClient)){
					p.getLocation().remove(i);
					if(!p.getLocation().isEmpty()){
						return "подбил";
						
					}
				}
			}
			
		}
		for(int i = 0; i < als.size(); i++){
			if(als.get(i).getLocation().isEmpty()){
				als.remove(i);
				return "потопил";
			}
		}
		return null;
	}
	public boolean empty() {
		if(als.isEmpty()){
			return true;
		}
		return false;
	}	
}
