package edu.shag.lesson16.threads;

public class MyThread implements Runnable {
	private String str;
	

	public MyThread(String str) {
		this.str = str;
	}


	@Override
	public void run() {//� ���� ������ ����� ���������� ��� ��� � ���� ����
		
		for(int i = 0; i<10; i++){
			System.out.println("\t" + str);
		}
		
	}

}
