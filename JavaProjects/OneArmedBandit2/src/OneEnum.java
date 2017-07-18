
public enum OneEnum {
	
	SEVEN("7"), STARS("*"), DOUBLE_STARS("**");
	private String symbol;
	private OneEnum(String symbol)
	{
		this.symbol = symbol;
	}
	public String getSymbol()
	{
		return symbol;
	}
}
