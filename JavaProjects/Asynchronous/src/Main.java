import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


public class Main {

	public static void main(String[] args) {
		// ������� ������-�����������.. ��������������� ������ ������!!!!
		
		//ExecutorService executor = Executors.newSingleThreadExecutor();
		//Scanner sc = new Scanner(System.in);
		//ExecutorService executor = Executors.newFixedThreadPool(2);
		ExecutorService executor = Executors.newWorkStealingPool();// ����� ���������� � ����������� �� ���������� ��������� ������� ���� �� �����!
		// ���� ������� - ��������� �������� ������������ ������ �������!
		//newSingleThreadExecutor(); ����� ������� �� ����� ��� 1 �����
		//  ���� ����� ����� ��������� ������� , � � ��������� ��� newFixedThreadPool(2);
		
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
		if(!executor.isTerminated()){// ���� �� ���������� �����, ����� �������������
			executor.shutdownNow();//���������� ����������� � ���������� ������ � ���������� � ���// ������������� ���������� �����
		}*/
		
		
		/*Future<Integer> future = executor.submit(new Calc(2, 3));
		System.out.println(" ready? " + future.isDone());//���������� ������� ��������, ���� �������� ������ - ����� ���
		double result = 0;
		try {
			result = future.get();// ����� �����������, ��� ��� ������ ��������������� ��� ������ ���� �� ������� ���� ���������!
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
		}
		System.out.println(" ready? " + future.isDone());
		System.out.println(result);
		executor.shutdown();// ��� ���������� ����� �������� ���������� � ���� �����������.. ����� ��� ������ ������ ������� ����� ������  executor.submit(new Calc(3,4)); ----���
		*/
		//int c = sc.nextInt();
		Future<Integer> future1 = executor.submit(new Calc(2, 3));
		Future<Integer> future2 = executor.submit(new Calc(3, 7));
		System.out.println(" ready? " + future2.isDone());//���������� ������� ��������, ���� �������� ������ - ����� ���
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
			result1 = future1.get();// ����� �����������, ��� ��� ������ ��������������� ��� ������ ���� �� ������� ���� ���������!
			result2 = future2.get();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
		}
		System.out.println(" ready? " + future2.isDone());
		System.out.println(result1 + " " + result2);
		executor.shutdown();// ��� ���������� ����� �������� ���������� � ���� �����������.. ����� ��� ������ ������ ������� ����� ������  executor.submit(new Calc(3,4)); ----���
		
		
		
	}

}
