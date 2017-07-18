
public class Main {

	public static void main(String[] args) {
		double x = 2.5, y = 3.75;
		Calc[] c = new Calc[4];
		c[0]=  new Calc2(x);
		c[1]=  new Calc3(x);
		c[2]=  new Calc4(y);
		c[3]=  new Calc5(x);
		
		Thread[] t = new Thread[c.length];
		for(int i = 0; i < t.length; i++){
			t[i] = new Thread(c[i]);
		}
		for(int i = 0; i < t.length; i++){
			t[i].start();
		}
		for(int i = 0; i < t.length; i++){
			try {
				t[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		double result = 0;
		for(int i = 0; i < t.length; i++){
			result += c[i].getRes();
		}
		System.out.println(result);

	}

}
