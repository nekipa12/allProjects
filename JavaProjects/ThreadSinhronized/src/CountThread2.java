import java.util.concurrent.locks.ReentrantLock;


public class CountThread2 implements Runnable {

	Resource res;
	ReentrantLock locker;
	
	public CountThread2(Resource res, ReentrantLock locker) {
		this.res = res;
		this.locker = locker;
	}

	@Override
	public void run() {
		int resu;
		locker.lock();
		res.x = 1;
		for(int i = 0; i < 5; i++){
			res.x++;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		resu = res.x;
		locker.unlock();//лок и анлок нужно писать в трай кетче, анлок нужно писать в блоке finally
		System.out.println(resu + " from thread " + Thread.currentThread().getName());
		
	}

}
