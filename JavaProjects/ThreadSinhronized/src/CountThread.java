
public class CountThread implements Runnable{
	Resource res;
	
	public CountThread(Resource res) {
		this.res = res;
	}

	@Override
	public void run() {
		int resu;
		synchronized (res) {//когда выполнение кода доходит до этого оператора, доступ к разделяемому ресурсу
							//имеет только один трэд который раньше всех произвел блокировку
			//при его применении производительность падает, применять его нужно когда есть в нём потребность!
			
		
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
			
		}
		System.out.println(resu + " from thread " + Thread.currentThread().getName());
		
	}
	
	
}
