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
			System.out.println("ДЖЕК-ПОТ");
			System.out.println("Ваш выигрыш равен : " + c);
			System.out.println("Ваш баланс : "+getPurse()+ " коинов");
		}else if(z2==3)
		{
			int c =minus*1;
			int d= getPurse()+c;
			setPurse(d);
			System.out.println("ВЫ ВЕЗУНЧИК, ОСТАЛИСЬ ПРИ СВОИХ");
			System.out.println("Ваш выигрыш равен : " + c);
			System.out.println("Ваш баланс : "+getPurse()+ " коинов");
		}else if(z3==3)
		{
			int c =minus*2;
			int d= getPurse()+c;
			setPurse(d);
			System.out.println("ВЫ ПРИУМНОЖИЛИ СВОЮ СТАВКУ");
			System.out.println("Ваш выигрыш равен : " + c);
			System.out.println("Ваш баланс : "+getPurse()+ " коинов");
		}else if(z1==2 && z2==1)
		{
			int c =minus*3;
			int d= getPurse()+c;
			setPurse(d);
			System.out.println("ВАМ СЕГОДНЯ ВЕЗЁТ, х3");
			System.out.println("Ваш выигрыш равен : " + c);
			System.out.println("Ваш баланс : "+getPurse()+ " коинов");
		}else if(z1==2 && z3==1)
		{
			int c =minus*4;
			int d= getPurse()+c;
			setPurse(d);
			System.out.println("ВАМ СЕГОДНЯ ВЕЗЁТ, х4");
			System.out.println("Ваш выигрыш равен : " + c);
			System.out.println("Ваш баланс : "+getPurse()+ " коинов");
		}
	}
	public void purseAddMethod()
	{	System.out.println("Введите к-во коинов для пополнения баланса");
		Scanner sc = new Scanner (System.in);
		int balance = sc.nextInt();
		setPurse(balance);
		System.out.println("Ваш баланс : "+getPurse()+ " коинов");
	}
	public void twistDrum(Drum[] drumNums, int count)
	{		
		
		
			while(true)
			{
				if(getPurse()>0 && !(getPurse()<=0) )
				{
					System.out.println("Сделайте вашу ставку");
					Scanner sc = new Scanner (System.in);
					try {
                        int minus = sc.nextInt();
                        if (minus <= getPurse()) {
                            int c = getPurse() - minus;
                            setPurse(c);
                            System.out.println("У вас осталось : " + getPurse() + " коинов");
                            System.out.println("Нажмите 1 чтобы крутить барабан,"
                                    + " 0 чтобы покинуть игру");
                            int spin = sc.nextInt();
                            if (spin == 1) {
                                int z1 = 0, z2 = 0, z3 = 0;
                                recurs(drumNums, count, z1, z2, z3, minus);
                            } else if (spin == 0) return;
                        } else System.out.println("Ваша ставка больше вашего баланса,"
                                + " пожалуйста сделайте ставку меньше!!!");
                    } catch (Exception e) {
                        System.out.println("Вы ввели неправельное значение, пожалуйста попробуйте снова ");
                    }
				}	
				else 
				{
					System.out.println("На вашем балансе 0 коинов, пополните "
										+ "	счет для того чтобы начать игру");
					purseAddMethod();
				}
				
			}
		
	}		
	public void game(Drum[] drumNums, int count)
	{
		twistDrum(drumNums, count);
		System.out.println("Ваш баланс : "+getPurse()+ " коинов");
	}	
	
	public static void main(String[] args) 
	{
		int count = 0;
		Drum [] drumNums = new Drum[3];
		drumNums[0] = new Drum(OneArmedBanditEnum.SEVEN);
		drumNums[1] = new Drum(OneArmedBanditEnum.STARS);
		drumNums[2] = new Drum(OneArmedBanditEnum.DOUBLE_STARS);
		System.out.println("ПРАВИЛА ИГРЫ");
		System.out.println("если выпадает 7 7 7 - это джек-пот и ваша ставка умножается на 7");
		System.out.println("если выпадает * * * - вы ничего не теряете и ваша ставка возвращается на ваш счёт");
		System.out.println("если выпадает ** ** ** - ваша ставка умножается в два раза");
		System.out.println("если выпадает комбинация из 7 7 * или тому подобная - ставка умножается на 3");
		System.out.println("если выпадает комбинация из 7 7 ** - на счёт заходит ставка умноженная на 4");
		System.out.println();
		System.out.println("НАЧНЕМ ИГРУ");
		drumNums[0].game(drumNums, count);
	}	
}		
	


