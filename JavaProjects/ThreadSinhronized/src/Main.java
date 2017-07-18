import java.util.concurrent.Exchanger;
import java.util.concurrent.Phaser;
import java.util.concurrent.locks.ReentrantLock;


public class Main {
	
	/*public static void main(String [] args) {
		
		Resource res = new Resource();
		
		for(int i = 0; i < 4; i++){
			Thread t = new Thread(new CountThread(res));
			t.setName("Thread # " + i);
			t.start();
		}
		
	}*/
	/*public static void main(String [] args) {
	 *
		long t1 = System.currentTimeMillis();
		Resource res = new Resource();
		ReentrantLock locker = new ReentrantLock();
		
		for(int i = 0; i < 4; i++){
			Thread t = new Thread(new CountThread2(res, locker));
			t.setName("Thread # " + i);
			t.start();
		}
		long t2 = System.currentTimeMillis();
		System.out.println(t2-t1);
	}*/
	/*public static void main(String [] args) {
		//двухточечный обменн данными между потоками
		Exchanger<String> ex = new Exchanger<>();
		new Thread(new MyT1(ex)).start();
		new Thread(new MyT2(ex)).start();
		
		
	}*/
	
	public static void main(String [] args) {
		// Взаимодействие потокоv при пофазном выполнении кода!
		Phaser ph = new Phaser(1);//еденица для корректности, если передать ноль то гавный поток не подписываеться на этот  phaser
		new Thread(new PT(ph, "PT1")).start();
		new Thread(new PT(ph, "PT2")).start();
		
		int phase = ph.getPhase(); // определение фазы выполнения потоков
		ph.arriveAndAwaitAdvance();// барьерная синхронизация, когда все доходят к этому барьеру только тогда все идут дальше!
		System.out.println("Фаза + "+ phase + " выполнена");
		
		phase = ph.getPhase(); // определение фазы выполнения потоков
		ph.arriveAndAwaitAdvance();
		System.out.println("Фаза + "+ phase + " выполнена");
		
		phase = ph.getPhase(); // определение фазы выполнения потоков
		ph.arriveAndAwaitAdvance();
		System.out.println("Фаза + "+ phase + " выполнена");
		
		ph.arriveAndDeregister();// отписаться от phaser он больше не контролирует метод кода!
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
