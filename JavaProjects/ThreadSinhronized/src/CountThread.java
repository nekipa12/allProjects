
public class CountThread implements Runnable{
	Resource res;
	
	public CountThread(Resource res) {
		this.res = res;
	}

	@Override
	public void run() {
		int resu;
		synchronized (res) {//����� ���������� ���� ������� �� ����� ���������, ������ � ������������ �������
							//����� ������ ���� ���� ������� ������ ���� �������� ����������
			//��� ��� ���������� ������������������ ������, ��������� ��� ����� ����� ���� � �� �����������!
			
		
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
