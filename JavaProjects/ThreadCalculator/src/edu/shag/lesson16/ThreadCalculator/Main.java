package edu.shag.lesson16.ThreadCalculator;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		//ВЕКТОРНЫЙ ВАРИАНТ ЯПФ
		byte [][][] matrix = new byte [8][2000][2000];
		Random rnd = new Random();
		for(int i = 0; i<matrix.length; i++){
			for(int j = 0; j<matrix.length; j++){
				for(int k = 0; k<matrix.length; k++){
					matrix[i][j][k] = (byte)(rnd.nextInt(256)-128);
				}
			}
		}
		
		long t1 = System.currentTimeMillis();
		Calc [] calc = new Calc[4];
		Thread [] thread = new Thread[4];
		for(int i = 0; i<calc.length; i++){
			calc[i] = new Calc(matrix[i*2], matrix[i+1]);
			thread[i] = new Thread(calc[i]);
		}
		for(int i = 0; i<calc.length; i++){
			thread[i].start();
		}
		for(int i = 0; i<calc.length; i++){
			try {
				thread[i].join();				//этот метод ждёт пока все задачи ядер будут завершены!!!!
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Calc [] calc2 = new Calc[2];
		Thread [] thread2 = new Thread[2];
		for(int i = 0; i<calc2.length; i++){
			calc2[i] = new Calc(calc[i].getRes(), calc[2*i+1].getRes());
			thread2[i] = new Thread(calc2[i]);
		}
		for(int i = 0; i<calc2.length; i++){
			thread2[i].start();
		}
		for(int i = 0; i<calc2.length; i++){
			try {
				thread2[i].join();				//этот метод ждёт пока все задачи ядер будут завершены!!!!
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		Calc calc3 = new Calc(calc2[0].getRes(), calc2[1].getRes());
		Thread thread3 = new Thread(calc3);
		thread3.start();
		try {
			thread3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long t2 = System.currentTimeMillis();
		System.out.println(t2-t1);
		
		
		
		
		
		
		
		
		
		
		
		//
				/*byte [][][] matrix = new byte [8][4000][4000];
				Random rnd = new Random();
				for(int i = 0; i<matrix.length; i++){
					for(int j = 0; j<matrix.length; j++){
						for(int k = 0; k<matrix.length; k++){
							matrix[i][j][k] = (byte)(rnd.nextInt(256)-128);
						}
					}
				}
				long t1 = System.currentTimeMillis();
				Calc [] calc = new Calc[4];
				for(int i = 0; i<calc.length; i++){
					calc[i] = new Calc(matrix[i*2], matrix[i+1]);
				}
				for(int i = 0; i<calc.length; i++){
					calc[i].run();
				}
				for(int i = 0; i<calc.length; i++){
				}
				Calc [] calc2 = new Calc[2];
				for(int i = 0; i<calc2.length; i++){
					calc2[i] = new Calc(calc[i].getRes(), calc[2*i+1].getRes());
				}
				for(int i = 0; i<calc2.length; i++){
					calc2[i].run();
				}
				Calc calc3 = new Calc(calc2[0].getRes(), calc2[1].getRes());
				calc3.run();
				long t2 = System.currentTimeMillis();
				System.out.println(t2-t1);*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
