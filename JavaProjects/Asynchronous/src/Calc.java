import java.util.concurrent.Callable;


public class Calc implements Callable<Integer>{//вызываемое, шаблон это тип возвращаемого значения
	int a; int b;

	public Calc(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public Integer call() throws Exception {//умеет бросать проверямое checked
		try{
			Thread.sleep(3000);
		} catch(Exception e){
			
		}
		
		
		return a+b;
	}
	
	
}
