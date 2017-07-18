import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


public class Main {

	public static void main(String[] args) {
		// создаем сервис-исполнитель.. высокоуровневая замена трэдам!!!!
		
		//ExecutorService executor = Executors.newSingleThreadExecutor();
		//Scanner sc = new Scanner(System.in);
		//ExecutorService executor = Executors.newFixedThreadPool(2);
		ExecutorService executor = Executors.newWorkStealingPool();// пусть приложение в зависимости от процессора определит сколько ядер ей нужно!
		// пулл потоков - позволяет повторно пользоваться старым потоком!
		//newSingleThreadExecutor(); будет браться не более чем 1 поток
		//  если нужно взять несколько потоков , а в частности два newFixedThreadPool(2);
		
		/*executor.submit(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					System.out.println("dfgdfgg");
				}
				System.out.println("Hello from Thread " + Thread.currentThread().getName());
				
			}
		});*/
		/*System.out.println("Next code");
		try {
			executor.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!executor.isTerminated()){// если не остановлен поток, тогда останавливаем
			executor.shutdownNow();//возвращает выброшенные у экзекутора потоки и возвращает в пул// останавливает немедленно поток
		}*/
		
		
		/*Future<Integer> future = executor.submit(new Calc(2, 3));
		System.out.println(" ready? " + future.isDone());//возвращает булевое значение, если значение готово - вернёт тру
		double result = 0;
		try {
			result = future.get();// метод блокирующий, при его вызове останавливаются все потоки пока не достану себе результат!
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
		}
		System.out.println(" ready? " + future.isDone());
		System.out.println(result);
		executor.shutdown();// ждёт завершения задач потоками связанными с этим экзекутором.. после его вызова нельзя ставить новые задачи  executor.submit(new Calc(3,4)); ----ему
		*/
		//int c = sc.nextInt();
		Future<Integer> future1 = executor.submit(new Calc(2, 3));
		Future<Integer> future2 = executor.submit(new Calc(3, 7));
		System.out.println(" ready? " + future2.isDone());//возвращает булевое значение, если значение готово - вернёт тру
		int result1 = 0;
		int result2 = 0;
		while(!future1.isDone()){
			System.out.println("Waiting");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			result1 = future1.get();// метод блокирующий, при его вызове останавливаются все потоки пока не достану себе результат!
			result2 = future2.get();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
		}
		System.out.println(" ready? " + future2.isDone());
		System.out.println(result1 + " " + result2);
		executor.shutdown();// ждёт завершения задач потоками связанными с этим экзекутором.. после его вызова нельзя ставить новые задачи  executor.submit(new Calc(3,4)); ----ему
		
		
		
	}

}
