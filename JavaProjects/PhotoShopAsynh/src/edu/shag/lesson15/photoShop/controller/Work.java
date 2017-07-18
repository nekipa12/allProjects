package edu.shag.lesson15.photoShop.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.imageio.ImageIO;
import edu.shag.lesson15.photoShop.model.Shag;
import edu.shag.lesson15.photoShop.view.View;

public class Work {
	
	private View aView;
	private BufferedImage bufImg;
	private FileInputStream fis;
	private DataInputStream dis;
	private byte[][][] matrix;
	private long t1;
	private long t2;
	private ExecutorService executor;
	private Shag[] s;
	private Future<byte [][]> future;
	private FileOutputStream fos;
	private DataOutputStream dos;
	
	public Work() {
		aView = new View();
	}

	public void start(){
		loadingMyPictureIn();
		editMyPicture();
		loadingMyPictureOut();
	}
	
	private void loadingMyPictureIn(){
		try {
			bufImg = ImageIO.read(new File(aView.inputDir()));
			fis = new FileInputStream(aView.inputDir());
			dis = new DataInputStream(new BufferedInputStream(fis));
			writeInMatrix();
			
		} catch (IOException e) {}
		finally{
			try {
				fis.close();
				dis.close();
			} catch (IOException e) {
			}
		}
	}
	
	private void writeInMatrix(){
		matrix = new byte[3][bufImg.getHeight()][bufImg.getWidth()+1];
		t1 = System.currentTimeMillis();
		for(int i = 0; i<matrix.length; i++){
	    	for(int j = 0; j<matrix[i].length; j++){
	    		for(int k = 0; k<matrix[i][j].length; k++){
	    			try {
						matrix[i][j][k] = dis.readByte();
					} catch (IOException e) {
					}
	    		}
	    	}
		}
		t2 = System.currentTimeMillis();
		aView.getTime(t1, t2);
	}
	
	private void editMyPicture() {
		executor = Executors.newCachedThreadPool();
		s = new Shag[3];
		t1 = System.currentTimeMillis();
		for(int i = 0; i < s.length; i++) {
			future = executor.submit(s[i] = new Shag(matrix[i]));
		}
		while(!future.isDone()){
			aView.waitDot();
		}
		executor.shutdown();
		t2 = System.currentTimeMillis();
		aView.getTime(t1, t2);
	}
	
	private void loadingMyPictureOut() {
		try {
			fos = new FileOutputStream(aView.inputDirNew());
			dos = new DataOutputStream(new BufferedOutputStream(fos));
			t1 = System.currentTimeMillis();
			for(int i = 0; i < matrix.length; i++){
		    	for(int j = 0; j < matrix[i].length; j++){
		    		for(int k = 0; k < matrix[i][j].length; k++){
		    			try {
							dos.writeByte(matrix[i][j][k]);
						} catch (IOException e) {
						}
		    		}
		    	}
		   }
			t2 = System.currentTimeMillis();
			aView.getTime(t1, t2);
		} catch (FileNotFoundException e) {
		} finally{
			try {
				dos.close();
				fos.close();
			} catch (IOException e) {
			}
		}
	}
}
