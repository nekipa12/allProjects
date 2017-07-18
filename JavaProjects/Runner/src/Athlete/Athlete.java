package Athlete;

import java.util.Arrays;

public class Athlete {

	private String name;
	private double time;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getTime() {
		return time;
	}
	public void setTime(double time) {
		this.time = time;
	}
	private void method(){
		
		double t =3+(Math.random()*1.001);
		setTime(t);
	}
		
	public Athlete(String name) {
		this.name = name;
		method();
	}
	
	@Override
	public String toString() {
		return "name= " + name + ", time= " + time;
	}
	
	
	public static void main(String[] args) {
		
		Athlete [] atl = new Athlete[3]; 
		atl[0] = new Athlete("Woody");
		atl[1] = new Athlete("Jimmy");
		atl[2] = new Athlete("Gomer");
		Arrays.sort(atl, new Imp());
		System.out.println("время"+"\t"+"имя");
		for(int i = 0; i<atl.length; i++) {
			System.out.printf("%.3f",atl[i].getTime(),"\t");
			System.out.println("\t"+atl[i].getName());
			
		}	
		System.out.println("Золото " + atl[0].getName() + "\n" + "Серебро " + atl[1].getName() + "\n"
							+ "Бронза " + atl[2].getName());
	}	
}		
	


