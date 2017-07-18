import java.util.concurrent.Exchanger;


public class MyT2 implements Runnable {
	String message;
	Exchanger<String> ex;
	
	public MyT2(Exchanger<String> ex) {
		this.ex = ex;
		message = "Hello from MyT2";
	}

	@Override
	public void run() {
		try {
			System.out.println("MyT2 doing some work");
			Thread.sleep(3000);
			message = ex.exchange(message);
			System.out.println(message+ " printed from MyT2");
		} catch (InterruptedException e) {}
		
	}
}
