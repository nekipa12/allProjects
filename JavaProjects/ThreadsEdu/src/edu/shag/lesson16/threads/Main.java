package edu.shag.lesson16.threads;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		MyThread mt = new MyThread("Hello from Thread");
		
		Scanner sc = new Scanner(System.in);
		//sc.nextLine();
		
		//mt.run();// если сделать так то метод ран будет выполнен в текущем потоке
		Thread t = new Thread(mt);
		AnnotherThread at = new AnnotherThread();
		Thread t2 = new Thread(at);
		sc.next();
		//t.setName("MyThreads!!!!");
		//System.out.println(t.getState());
		t.start();
		t2.setDaemon(true);//метод который делает поток фоновым
		t2.start();
		//System.out.println(t.getState());
		/*MyThread2 mt2 = new MyThread2("Hello from Thread");
		mt2.start();*/
		for(int i = 0; i<10; i++) {//вариант с наследованием не подходит, а вариант с интерфейсом более подходящий
			System.out.println("Hello from Main");
		}
		//System.out.println(t.getState());
		
		
		
	}

}
