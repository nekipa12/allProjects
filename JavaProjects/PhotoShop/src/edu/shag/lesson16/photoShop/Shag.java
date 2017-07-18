package edu.shag.lesson16.photoShop;

public class Shag implements Runnable {
	private byte [][] B;
	private int count;
	
	public Shag(byte[][] b) {
		B = b;
	}
	@Override
	public void run() {
		for(int i = 0; i<B.length; i++){
			for(int j = 0; j<B[i].length; j++){
				if(i == 0 && count<54 && j <54){
					count++;
					continue;
				}
				B[i][j] *= 1.5;
			}
		}
	}
}
