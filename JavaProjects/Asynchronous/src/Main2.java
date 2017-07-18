
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import javax.naming.spi.DirStateFactory.Result;


public class Main2 {

	public static void main(String[] args) {

		/*ExecutorService executor = Executors.newWorkStealingPool();
		ArrayList<Callable<Double>> tasks = new ArrayList<>(); // ����������� ������ �����... ������ ��������� � ���� ���������
		tasks.add(new C1(2.5));
		tasks.add(new C2(2.5));
		tasks.add(new C3(3.5));
		tasks.add(new C4(2.5));
		try {
			double Res = 0;
			List<Future<Double>> results = executor.invokeAll(tasks);
			for(Future<Double> res : results){
			try {
				Res += res.get();// �������� � ��� ��� �� ���������� �� � ������� ���������� ����������� � �� ����������� ������!
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
			System.out.println(Res);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			executor.shutdown();
		}
		System.out.println("Doing some work in main thread");
		
		// ���� �� ����� �������� ���������� ������ � ������� ������������ ���������
		*/
		/*ExecutorService executor1 = Executors.newWorkStealingPool();
			CompletionService<Double> tC = new ExecutorCompletionService<Double>(executor1);// ������ ����������� ... �����
			ArrayList<Callable<Double>> task = new ArrayList<>(); // ����������� ������ �����... ������ ��������� � ���� ���������
			task.add(new C1(2.5));
			task.add(new C2(2.5));
			task.add(new C3(3.5));
			task.add(new C4(2.5));
			
			for(Callable<Double> tas : task){
				tC.submit(tas);
			}
			for(int i = 0; i<task.size(); i++){
				try {
					Future<Double> res = tC.take();
					try {
						System.out.println(res.get());
					} catch (ExecutionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // ����� ������ ���������� ����������� ������
				
			}
			executor1.shutdown();
		*/
		
		
		//������ �� ����������
		
		ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
		C1 c1 = new C1(3.5);
		ScheduledFuture<Double> result = 
		ses.schedule(c1, 5, TimeUnit.SECONDS);
		while(!result.isDone()){
			System.out.println("Waiting");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			System.out.println(result.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ses.shutdown();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
