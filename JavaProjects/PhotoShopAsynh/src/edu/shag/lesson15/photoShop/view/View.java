package edu.shag.lesson15.photoShop.view;

import java.util.Scanner;

public class View {
	private Scanner scLines;
	private Scanner scDigits;
	
	public View() {
		scLines = new Scanner(System.in);
		scDigits =new Scanner(System.in);
	}

	public String inputDir() {
		System.out.println("������� ���� � ����� ��� ������������� ��� ����������");
		if(scLines.hasNextLine()) return scLines.nextLine();
		else return "���� �� ���������� ��� ������ �� �����";
		
	}

	public void getTime(long t1, long t2) {
		System.out.println("����� ���������� " + (t2 - t1) + " ms");
		
	}

	public void waitDot() {
		System.out.print(".");
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {}
		
	}

	public String inputDirNew() {
		System.out.println("������� ���� ��� �������� ������ ����� ��� ���������� �������");
		if(scLines.hasNextLine()) return scLines.nextLine();
		else return "���� �� ���������� ��� ������ �� �����";
		
	}
	
	
	
}
