package edu.shag.lesson16.seaBattleServer.model;


public enum Direction {
	
	A(0),B(1),C(2),D(3),E(4),F(5),G(6),H(7),I(8),J(9);
	
	private int digit;
	private Direction(int digit)
	{
		this.digit = digit;
	}
	public int getDigit() {
		return digit;
	}
	

}
