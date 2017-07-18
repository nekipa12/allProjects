package edu.shag.lesson11.OneArmedBandit;

public enum OneArmedBanditEnum 
{
	
	
	SEVEN("7"), STARS("*"), DOUBLE_STARS("**");
	private String symbol;
	private OneArmedBanditEnum(String symbol)
	{
		this.symbol = symbol;
	}
	public String getSymbol()
	{
		return symbol;
	}
	
}
