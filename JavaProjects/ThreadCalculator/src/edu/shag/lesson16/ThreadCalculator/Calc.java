package edu.shag.lesson16.ThreadCalculator;

public class Calc implements Runnable {
	//векторный способ решения многопоточного вопроса. подходит когда каждый тред будет делать одно и тоже
	//но под разными данными
	private byte [][] A;
	private byte [][] B;
	private byte [][] res;
	
	public byte[][] getRes() {
		return res;
	}

	public void setRes(byte[][] res) {
		this.res = res;
	}

	public Calc(byte[][] a, byte[][] b) {
		A = a;
		B = b;
		res = new byte[A.length][A[0].length];
	}

	@Override
	public void run() {
		for(int i = 0; i<A.length; i++){
			for(int j = 0; j<A[i].length; j++){
				res[i][j] = (byte)(A[i][j] + B[i][j]);
			}
		}
		
	}
	
}
