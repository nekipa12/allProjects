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
		//������������ ������ ������� ����� ��������
		Exchanger<String> ex = new Exchanger<>();
		new Thread(new MyT1(ex)).start();
		new Thread(new MyT2(ex)).start();
		
		
	}*/
	
	public static void main(String [] args) {
		// �������������� ������v ��� �������� ���������� ����!
		Phaser ph = new Phaser(1);//������� ��� ������������, ���� �������� ���� �� ������ ����� �� �������������� �� ����  phaser
		new Thread(new PT(ph, "PT1")).start();
		new Thread(new PT(ph, "PT2")).start();
		
		int phase = ph.getPhase(); // ����������� ���� ���������� �������
		ph.arriveAndAwaitAdvance();// ��������� �������������, ����� ��� ������� � ����� ������� ������ ����� ��� ���� ������!
		System.out.println("���� + "+ phase + " ���������");
		
		phase = ph.getPhase(); // ����������� ���� ���������� �������
		ph.arriveAndAwaitAdvance();
		System.out.println("���� + "+ phase + " ���������");
		
		phase = ph.getPhase(); // ����������� ���� ���������� �������
		ph.arriveAndAwaitAdvance();
		System.out.println("���� + "+ phase + " ���������");
		
		ph.arriveAndDeregister();// ���������� �� phaser �� ������ �� ������������ ����� ����!
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
