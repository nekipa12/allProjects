import java.util.Collection;
import java.util.concurrent.Callable;


abstract class C implements Callable<Double> {
	double x;
	public C(double x) {
		this.x = x;
	}
	
	

}
