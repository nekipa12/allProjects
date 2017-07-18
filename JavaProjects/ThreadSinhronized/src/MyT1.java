import java.util.concurrent.Exchanger;


public class MyT1 implements Runnable{

	String message;
	Exchanger<String> ex;
	
	public MyT1(Exchanger<String> ex) {
		this.ex = ex;
		message = "Hello from MyT1";
	}

	@Override
	public void run() {
		try {
			System.out.println("MyT1 doing some work");
			Thread.sleep(2000);
			message = ex.exchange(message);// точка взаимного обмена
		} catch (InterruptedException e) {}
		System.out.println(message+ " printed from MyT1");
	}
	
	
}
