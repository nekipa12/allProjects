package model;

import java.util.Random;

public class Bone {
	
	private int points;
	private Random rnd;
	
	public Bone() {
		points = 0;
		rnd = new Random();
	}
	
	public void drop(){
		points = 1 + rnd.nextInt(6);
	}

	public int getPoints() {
		return points;
	}

	@Override
	public String toString() {
		return "Bone points= " + points;
	}
	
}
