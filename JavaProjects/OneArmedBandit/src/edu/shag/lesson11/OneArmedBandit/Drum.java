package edu.shag.lesson11.OneArmedBandit;

import java.util.Random;
import java.util.Scanner;

public class Drum 
{
	private int purse; 
	private OneArmedBanditEnum drumTurn;
	
	public int getPurse() {
		return purse;
	}
	public void setPurse(int purse) {
		this.purse = purse;
	}
	public OneArmedBanditEnum getDrumTurn() {
		return drumTurn;
	}
	
	public Drum(OneArmedBanditEnum drumTurn) 
	{
		this.drumTurn = drumTurn;
	}
	
	@Override
	
	public String toString() 
	{
		return drumTurn + "";
	}

	public void recurs(Drum[] drumNums, int count,int z1, int z2, int z3, int minus)
	{	
		int a = 0;
		if(count == 3)
		{
			return;
		}
		Random rnd = new Random();
		a = rnd.nextInt(drumNums.length);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.print(drumNums[a].drumTurn.getSymbol()+"\t");
		System.out.print("");
		if(a == 0)
		{ 
			z1++;
		}else if(a== 1)
		{
			z2++;
		}else
		{
			z3++; 
		}
		count++;
		recurs(drumNums, count,z1, z2, z3, minus);
		ret(z1,z2,z3, minus);
	}
	public void ret(int z1, int z2, int z3, int minus){
		
		if(z1==3)
		{
			int c =minus*7;
			int d= getPurse()+c;
			setPurse(d);
			System.out.println("����-���");
			System.out.println("��� ������� ����� : " + c);
			System.out.println("��� ������ : "+getPurse()+ " ������");
		}else if(z2==3)
		{
			int c =minus*1;
			int d= getPurse()+c;
			setPurse(d);
			System.out.println("�� ��������, �������� ��� �����");
			System.out.println("��� ������� ����� : " + c);
			System.out.println("��� ������ : "+getPurse()+ " ������");
		}else if(z3==3)
		{
			int c =minus*2;
			int d= getPurse()+c;
			setPurse(d);
			System.out.println("�� ����������� ���� ������");
			System.out.println("��� ������� ����� : " + c);
			System.out.println("��� ������ : "+getPurse()+ " ������");
		}else if(z1==2 && z2==1)
		{
			int c =minus*3;
			int d= getPurse()+c;
			setPurse(d);
			System.out.println("��� ������� ��Ǩ�, �3");
			System.out.println("��� ������� ����� : " + c);
			System.out.println("��� ������ : "+getPurse()+ " ������");
		}else if(z1==2 && z3==1)
		{
			int c =minus*4;
			int d= getPurse()+c;
			setPurse(d);
			System.out.println("��� ������� ��Ǩ�, �4");
			System.out.println("��� ������� ����� : " + c);
			System.out.println("��� ������ : "+getPurse()+ " ������");
		}
	}
	public void purseAddMethod()
	{	System.out.println("������� �-�� ������ ��� ���������� �������");
		Scanner sc = new Scanner (System.in);
		int balance = sc.nextInt();
		setPurse(balance);
		System.out.println("��� ������ : "+getPurse()+ " ������");
	}
	public void twistDrum(Drum[] drumNums, int count)
	{		
		
		
			while(true)
			{
				if(getPurse()>0 && !(getPurse()<=0) )
				{
					System.out.println("�������� ���� ������");
					Scanner sc = new Scanner (System.in);
					try {
                        int minus = sc.nextInt();
                        if (minus <= getPurse()) {
                            int c = getPurse() - minus;
                            setPurse(c);
                            System.out.println("� ��� �������� : " + getPurse() + " ������");
                            System.out.println("������� 1 ����� ������� �������,"
                                    + " 0 ����� �������� ����");
                            int spin = sc.nextInt();
                            if (spin == 1) {
                                int z1 = 0, z2 = 0, z3 = 0;
                                recurs(drumNums, count, z1, z2, z3, minus);
                            } else if (spin == 0) return;
                        } else System.out.println("���� ������ ������ ������ �������,"
                                + " ���������� �������� ������ ������!!!");
                    } catch (Exception e) {
                        System.out.println("�� ����� ������������ ��������, ���������� ���������� ����� ");
                    }
				}	
				else 
				{
					System.out.println("�� ����� ������� 0 ������, ��������� "
										+ "	���� ��� ���� ����� ������ ����");
					purseAddMethod();
				}
				
			}
		
	}		
	public void game(Drum[] drumNums, int count)
	{
		twistDrum(drumNums, count);
		System.out.println("��� ������ : "+getPurse()+ " ������");
	}	
	
	public static void main(String[] args) 
	{
		int count = 0;
		Drum [] drumNums = new Drum[3];
		drumNums[0] = new Drum(OneArmedBanditEnum.SEVEN);
		drumNums[1] = new Drum(OneArmedBanditEnum.STARS);
		drumNums[2] = new Drum(OneArmedBanditEnum.DOUBLE_STARS);
		System.out.println("������� ����");
		System.out.println("���� �������� 7 7 7 - ��� ����-��� � ���� ������ ���������� �� 7");
		System.out.println("���� �������� * * * - �� ������ �� ������� � ���� ������ ������������ �� ��� ����");
		System.out.println("���� �������� ** ** ** - ���� ������ ���������� � ��� ����");
		System.out.println("���� �������� ���������� �� 7 7 * ��� ���� �������� - ������ ���������� �� 3");
		System.out.println("���� �������� ���������� �� 7 7 ** - �� ���� ������� ������ ���������� �� 4");
		System.out.println();
		System.out.println("������ ����");
		drumNums[0].game(drumNums, count);
	}	
}		
	


