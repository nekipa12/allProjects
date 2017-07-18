package edu.shag.lesson15.fileManagerInThreads.controller;

import java.io.File;

import edu.shag.lesson15.fileManagerInThreads.model.CopyTh;
import edu.shag.lesson15.fileManagerInThreads.view.ManagerView;

public class Work {
	private File f;
	private File [] fm ;
	private CopyTh[] ct;
	private Thread[] t;
	private long t1;
	private long t2;
	private ManagerView aView;
	
	public Work() {
		aView = new ManagerView();
	}

	public void start() {
		f = new File("C:/Users/nekip/OneDrive/");
		fm = f.listFiles();
		ct = new CopyTh[fm.length];
		t = new Thread[fm.length];
		t1 = System.currentTimeMillis();
		for(int i = 0; i < fm.length; i++){
			System.out.println(fm[i].getPath());
		}
		threadWork();
		methStart();
		methJoin();
		t2 = System.currentTimeMillis();
		aView.getTime(t1, t2);
	}
	
	private void threadWork() {
		for(int i = 0; i < t.length; i++){
			t[i] = new Thread(ct[i] = new CopyTh(fm[i].getPath(), fm[i].getName()));
		}
	}

	private void methStart() {
		for(int i = 0; i < t.length; i++){
			t[i].start();
		}
	}
	
	private void methJoin() {
		for(int i = 0; i < t.length; i++){
			try {
				t[i].join();
			} catch (InterruptedException e) {
			}
		}
	}
}
