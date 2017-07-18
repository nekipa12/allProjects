import java.util.Random;
import java.util.concurrent.Phaser;


public class PT implements Runnable {

	Phaser ph;
	String name;
	
	
	public PT(Phaser ph, String name) {
		
		this.ph = ph;
		this.name = name;
		ph.register();// подписывает текущий трэд на  phaser 
	}


	@Override
	public void run() {
		Random rnd = new Random();
		System.out.println(name  + " выполняет фазу " + ph.getPhase());
		try {
			Thread.sleep(rnd.nextInt(4000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ph.arriveAndAwaitAdvance();
		
		System.out.println(name  + " выполняет фазу " + ph.getPhase());
		try {
			Thread.sleep(rnd.nextInt(2000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ph.arriveAndAwaitAdvance();
		
		System.out.println(name  + " выполняет фазу " + ph.getPhase());
		try {
			Thread.sleep(rnd.nextInt(2000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ph.arriveAndDeregister();
		
	}

}
