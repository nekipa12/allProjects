package edu.shag.lessons6.home_work;
import java.util.Arrays;
import java.util.Random;

class Phone 
{
	/**
	 * ��������� �������
	 */
	private int battery;///////////
	/**
	 * ��������� ������
	 */
	private int take�all;/////////////////////////////
	/**
	 * ������
	 */
	private String makeNoise;////////////////
	/**
	 * ��������� �����
	 */
	private int[][] startScreen;//////////////
	/**
	 * ���������� �����
	 */
	private double time;//////////////
	/**
	 * ���������� �����(�����)
	 */
	private String[] contacts;/////
	/**
	 * ���������� �����(������ ���������)
	 */
	private int [] numbers;////////////////
	/**
	 * ����� �����
	 */
	private String talk;
	
	
	public int getBattery() 
	{
		return battery;
	}
	public void setBattery(int battery) 
	{
		this.battery = battery;
	}
	
	public int getTake�all() 
	{
		return take�all;
	}
	public void setTake�all(int take�all) 
	{
		this.take�all = take�all;
	}
	public String getMakeNoise() 
	{
		return makeNoise;
	}
	public void setMakeNoise(String makeNoise) 
	{
		this.makeNoise = makeNoise;
	}
	public int[][] getStartScreen() 
	{
		return startScreen;
	}
	public void setStartScreen(int[][] startScreen) 
	{
		this.startScreen = startScreen;
	}
	public double getTime() 
	{
		return time;
	}
	public void setTime(double time) 
	{
		this.time = time;
	}
	public String[] getContacts() 
	{
		return contacts;
	}
	public void setContacts(String[] contacts) 
	{
		this.contacts = contacts;
	}
	public int[] getNumbers() 
	{
		return numbers;
	}
	public void setNumbers(int[] numbers) 
	{
		this.numbers = numbers;
	}
	public String getTalk() 
	{
		return talk;
	}
	public void setTalk(String talk) 
	{
		this.talk = talk;
	}
	
	
	public Phone(int battery, int take�all, String makeNoise, int[][] startScreen, double time, String[] contacts, int[] numbers, String talk)
	{
		this.battery = battery;
		this.take�all = take�all;
		this.makeNoise = makeNoise;
		this.startScreen = new int[][]{};
		this.time = time;
		this.contacts = new String[]{};
		this.numbers = new int[]{};
		this.talk = talk;
	}
	
	public void offPhone()
	{
		System.out.println("������� ��������");
		cargeBattery();
	}
	
	
	public void onPhone()
	{	
		System.out.println("������� �������");
		while (this.battery!=0)
		{
			showScreen();
			this.battery--;
			System.out.println(this.battery+" %");
			if(this.battery == 10) System.out.println("����� ������ 10%, �������� �������");
			if(this.battery == 0) System.out.println("������� ��������"); 
		}
		if(this.battery <= 0)
		{
			this.battery=0;
			offPhone();
		}
	}
	
	
	public void showScreenWork(int c)
	{
		if(c==3)return;
		this.startScreen= new int[6][5];
		Random rnd = new Random();
		for (int i = 0; i<startScreen.length; i++)
		{
			for (int j = 0; j<startScreen[i].length; j++)
			{
				startScreen[i][j]=rnd.nextInt(256);
				System.out.print(startScreen[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println();
		c++;
		showScreenWork(c);
	}
	
	
	public void showScreen()
	{	
		int c1=0;
		showScreenWork(c1);
		System.out.println("��������� ��������� �����");
		showTime();
		incoming�all();
		out�all();
	}
	
	
	public void showTime()
	{
		if(this.time== 23.0) this.time=-1.00;
		this.time++;
		System.out.println("����� " + this.time + " ���(�,��)");
	}
	
	
	public void cargeBattery()
	{
		while(this.battery!=100)
		{
			this.battery++;
			System.out.println("������� ���������� " + this.battery + "%");
		}
		if(this.battery==100) System.out.println("������� �������� ���������!");
		Random rndGenerate = new Random();
		int buttonOn = rndGenerate.nextInt(2);
		if (buttonOn == 1)
		{
			System.out.println("�������� �������");
			onPhone();
		}else
		{
			System.out.println("�� �������� �������");
			offPhone();
		}
	}
	
	
	public void incoming�all()
	{
		Random rndGenerate = new Random();
		Random rndGenerateTwo = new Random();
		int generate = rndGenerate.nextInt(15);
		int generateTwo = rndGenerateTwo.nextInt(16);
		if(generate==generateTwo)
		{
			System.out.println(this.makeNoise);
			answer();
		} 
		return;
	}
	
	
	public void answer()
	{
		Random rndGenerateAns = new Random();
		System.out.println("������� ��� ��������� �����?");
		this.take�all = rndGenerateAns.nextInt(2);
		if(this.take�all ==1 && this.battery>10)
		{
			System.out.println("�������");
			this.battery-=5;
		}else System.out.println("���������");
		return;
	}
	
	
	public void out�all()
	{
		Random rndGenerate = new Random();
		Random rndGenerateTwo = new Random();
		int generate = rndGenerate.nextInt(15);
		int generateTwo = rndGenerateTwo.nextInt(11);
		if(generate==generateTwo && this.battery>10)
		{
			System.out.println(this.talk);
			makeCallOut();
			this.battery-=5;
		} 
		return;
	}
	
	
	public void makeCallOut()
	{
		this.contacts = new String [] {"Nikol", "Woody", "Stive", "Doolitle", "Ameli", "Molly"};
		this.numbers = new int[]{4456058, 8900587, 9499952, 2345087, 1920085691, 2108596200};
		int i, contacts1 = this.contacts.length;
		Random rndGenerate = new Random();
		int randomChoose = rndGenerate.nextInt(this.contacts.length);
		for ( i=0; i<contacts1; i++)
		{
			this.contacts[i]+="\t"+numbers[i];
		}
		System.out.println();
		Arrays.sort(this.contacts);
		System.out.println(this.contacts[randomChoose]);
	}
}
