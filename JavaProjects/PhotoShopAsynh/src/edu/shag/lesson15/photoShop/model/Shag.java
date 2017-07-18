package edu.shag.lesson15.photoShop.model;

import java.util.concurrent.Callable;

public class Shag implements Callable<byte[][]> {
	private byte [][] B;
	private int count;
	
	public Shag(byte[][] b) {
		B = b;
	}
	
	@Override
	public byte[][] call() throws Exception {
		for(int i = 0; i<B.length; i++){
			for(int j = 0; j<B[i].length; j++){
				if(i == 0 && count<54 && j <54){
					count++;
					continue;
				}
				B[i][j] *= 1.5;
			}
		}
		return B;
	}
}
