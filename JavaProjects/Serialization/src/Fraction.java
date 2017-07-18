import java.io.Serializable;


public class Fraction implements Serializable{ //классы которые хотим сериализовать так помечаются!!!
											
	private int numberator;
	private int denumberator;
	private Test t;
	
	public int getNumberator() {
		return numberator;
	}

	public void setNumberator(int numberator) {
		this.numberator = numberator;
	}

	public int getDenumberator() {
		return denumberator;
	}

	public void setDenumberator(int denumberator) {
		this.denumberator = denumberator;
	}

	public Test getT() {
		return t;
	}

	public void setT(Test t) {
		this.t = t;
	}
	

	public Fraction(int numberator, int denumberator, Test t) {
		super();
		this.numberator = numberator;
		this.denumberator = denumberator;
		this.t = t;
	}
	


	@Override
	public String toString() {
		return "Fraction [numberator=" + numberator + ", denumberator="
				+ denumberator + ", t=" + t + "]";
	}



	
	
	
}
