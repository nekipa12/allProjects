package edu.shag.lesson16.seaBattleClient.controller;

import java.util.ArrayList;

import edu.shag.lesson16.seaBattleClient.model.Direction;

public class MakeCoordinats {
	
	private Direction direction;
	private int gridLenght;
	private int gridSize;
	private int [] grid;
	private int count;
	
	public MakeCoordinats() {
		gridLenght = 10;
		gridSize = 100;
		grid = new int [gridSize];
		count = 0;
	}

	public ArrayList<String> makeAdress(int i) {
		ArrayList<String> cells = new ArrayList<>();
		String [] aCoords = new String[i];
		String temp = null;
		int[] coords = new int [i];
		int attemts = 0;
		boolean success = false;
		int location = 0;
		count++;
		int incr = 1;
		if((count % 2) == 1){
			incr = gridLenght;
		}
		while(!success & attemts++ < 200){
			location = (int) (Math.random() * gridSize);
			int x = 0;
			success = true;
			while(success && x < i){
				if(grid[location] == 0){
					coords[x++] = location;
					location += incr;
					if(location >= gridSize){
						success = false;
					}
					if(x > 0 && (location % gridLenght == 0)){
						success = false;
					}
				} else {
					success = false;
				}
			}
		}
		int x = 0;
		int row = 0;
		int column = 0;
		while(x < i){
			grid[coords[x]] = 1;
			row = (int) (coords[x] / gridLenght);
			column = coords[x] % gridLenght;
			int countFor = 0;
			for(Direction dir : direction.values()){
				if(countFor == column){
					temp = dir.name();
				}
				countFor++;
			}
			cells.add(temp.concat(Integer.toString(row)));
			x++;
		}
		return cells;
	}
}
