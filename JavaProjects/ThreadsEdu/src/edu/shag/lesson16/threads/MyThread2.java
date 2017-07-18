package edu.shag.lesson16.threads;

public class MyThread2 extends Thread{
	private String str;
	public MyThread2(String str) {
		this.str = str;
	}
	public void run() {//в этом методе будет выполнятся код это и есть тред
		//System.out.println(this.getState());
		for(int i = 0; i<100; i++){
			System.out.println("\t" + str);
		}
		
	}
}
