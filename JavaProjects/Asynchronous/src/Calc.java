import java.util.concurrent.Callable;


public class Calc implements Callable<Integer>{//����������, ������ ��� ��� ������������� ��������
	int a; int b;

	public Calc(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public Integer call() throws Exception {//����� ������� ���������� checked
		try{
			Thread.sleep(3000);
		} catch(Exception e){
			
		}
		
		
		return a+b;
	}
	
	
}
