
abstract class Calc implements Runnable {
	double x;
	double res;
	
	public Calc(double x) {
		this.x = x;
	}

	public double getRes(){
		return res;
	}

}
