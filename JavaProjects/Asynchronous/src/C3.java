
public class C3 extends C {

	public C3(double x) {
		super(x);
		
	}

	@Override
	public Double call() throws Exception {
		
		return  4*Math.pow(x, 4);
	}

}
