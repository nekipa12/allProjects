package edu.shag.lesson16.photoShop;

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
import java.util.Random;

import javax.imageio.ImageIO;

public class PhotoShop {
	
	public static void main(String[] args) {
		byte[] ccc = null;
		BufferedImage bufImg = null;
		try {
			bufImg = ImageIO.read(new File("./wear.bmp"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		FileInputStream f = null;
		DataInputStream dis = null;
		byte[][][] b = null;
		try {
			f = new FileInputStream("./wear.bmp");
			dis = new DataInputStream(new BufferedInputStream(f));
			long t1 = System.currentTimeMillis();
			b = new byte[3][bufImg.getHeight()][bufImg.getWidth()+1];
			
			
			
			byte[] cc = new byte[54];
			for(int i = 0; i<cc.length; i++){
				try {
					cc[i] = dis.readByte();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			Random rnd = new Random();
			ccc = new byte[1341*558*3+54];
			for(int i = 0; i<ccc.length; i++){
				if(i<=53){
					ccc[i] = cc[i];
				}else{
					ccc[i] = 127;/*(byte) rnd.nextInt();*/
				}
				
			}
			
			/*for(int i = 0; i<b.length; i++){
		    	for(int j = 0; j<b[i].length; j++){
		    		for(int k = 0; k<b[i][j].length; k++){
		    			try {
							b[i][j][k] = dis.readByte();
						} catch (IOException e) {
						}
		    		}
		    	}
			}*/
			long t2 = System.currentTimeMillis();
			System.out.println("������ � ������� "+(t2-t1)+" ms");
		} catch (FileNotFoundException e) {
		} finally{
			try {
				f.close();
				dis.close();
			} catch (IOException e) {
			}
		}
		long t3 = System.currentTimeMillis();
		Shag[] s = new Shag[3];	
		Thread [] thread = new Thread[3];
		for(int i = 0; i < s.length; i++) {
			s[i] = new Shag(b[i]);
			thread[i] = new Thread(s[i]);
		}
		for(int i = 0; i < s.length; i++) {
			thread[i].start();
		}
		for(int i = 0; i < s.length; i++) {
			try {
				thread[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} 
		long t4 = System.currentTimeMillis();
		System.out.println("���������� ������������� "+(t4-t3)+" ms");
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		try {
			fos = new FileOutputStream("./new.bmp");
			dos = new DataOutputStream(new BufferedOutputStream(fos));
			long t5 = System.currentTimeMillis();
			for(int i = 0; i<ccc.length; i++){
				try {
					dos.writeByte(ccc[i]);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			
			
			
			
			
			
			
			/*for(int i = 0; i<b.length; i++){
		    	for(int j = 0; j<b[i].length; j++){
		    		for(int k = 0; k<b[i][j].length; k++){
		    			try {
							dos.writeByte(b[i][j][k]);
						} catch (IOException e) {
						}
		    		}
		    	}
		   }*/
			long t6 = System.currentTimeMillis();
			System.out.println("������ � ���� "+(t6-t5)+" ms");
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