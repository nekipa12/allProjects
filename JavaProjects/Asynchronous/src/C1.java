
public class C1 extends C {

	public C1(double x) {
		super(x);
		
	}

	@Override
	public Double call() throws Exception {
		
		return 4*Math.pow(x, 6);
	}
	

}
