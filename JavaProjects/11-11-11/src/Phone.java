
import java.util.Arrays;
import java.util.Random;


public class Phone 
{
	
	/**
	 * заряд батареи
	 */
	private int battery;
	/**
	 * экран
	 */
	private int[][] screen;
	/**
	 * телефонная книга
	 */
	private String[] phonebook;
	/**
	 * номера телефонов
	 */
	private int [] phonenumbers;
	/**
	 * позвонить
	 */
	private int call;
	/**
	 * операторы связи
	 */
	private String[] operator;
	/**
	 * принимает звонок 	
	 */
	private String ring;
	
	
	public int getBattery() {
		return battery;
	}
	public void setBattery(int battery) {
		this.battery = battery;
	}
	public int[][] getScreen() {
		return screen;
	}
	public void setScreen(int[][] screen) {
		this.screen = screen;
	}
	public String[] getPhonebook() {
		return phonebook;
	}
	public void setPhonebook(String[] phonebook) {
		this.phonebook = phonebook;
	}
	public int[] getPhonenumbers() {
		return phonenumbers;
	}
	public void setPhonenumbers(int[] phonenumbers) {
		this.phonenumbers = phonenumbers;
	}
	public int getCall() {
		return call;
	}
	public void setCall(int call) {
		this.call = call;
	}
	public String[] getOperator() {
		return operator;
	}
	public void setOperator(String[] operator) {
		this.operator = operator;
	}
	public String getRing() {
		return ring;
	}
	public void setRing(String ring) {
		this.ring = ring;
	}	
	public Phone(int battery, int[][] screen,String[] phonebook,int [] phonenumbers,int call,String[] operator,String ring)
	{
		this.battery = battery;
		this.screen = screen;
		this.phonebook = phonebook;
		this.phonenumbers = phonenumbers;
		this.call = call;
		this.operator = operator;
		this.ring = ring;	
	}
		
	public  void PhoneOn ()
	{
		System.out.println("The Phone On");
		workbattery();
	}
	
	public void PhoneOff ()
	{
		System.out.println("The Phone Off");
		cargeBattery();
	}
	public void cargeBattery()
	{
		while(this.battery!=100)
		{
			this.battery++;
			System.out.println("Телефон заряжается " + this.battery + "%");
		}
		if(this.battery==100) System.out.println("Батарея заряжена полностью!");
		Random rndGenerate = new Random();
		int buttonOn = rndGenerate.nextInt(2);
		if (buttonOn == 1)
		{
			System.out.println("Включить телефон");
			PhoneOn();
		}else
		{
			System.out.println("Не включать телефон");
			PhoneOff();
		}
	}
	public void workbattery()
	{
		System.out.println("the Mobile Phone is working");
		 while(this.battery!=0)
		 {	 
			 showscreen();
			 this.battery--;
			 System.out.println(this.battery + " %");
			 if(this.battery==5)
				 System.out.println("the Mobile Phone discharget");
			 if(this.battery<=0)
				 System.out.println("the Mobile Phone isn't working");
			 
		}	 
		
		 PhoneOff();
	}
	public void workscreen(int aScreen)
	{
		Random rnd = new Random ();
		if(aScreen==3)return;
		this.screen = new int[7][5];
		for(int i = 0 ;i < this.screen.length;i++)
		{
			for(int j = 0; j < this.screen[i].length;j++)
			{
				this.screen[i][j] = rnd.nextInt(256);
				System.out.print(this.screen[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();	
		aScreen++;
		workscreen(aScreen);
				
	}
			
	public void showscreen()
	{
		int aScreen1 = 0;
		workscreen(aScreen1);
		System.out.println("showing the screen");
		showoperator();///////////////////////////////////////////////////////////
		outСall();
		incomingСall();
	}
	
	public void outСall()
	{
		Random rndGenerate = new Random();
		Random rndGenerateTwo = new Random();
		int generate = rndGenerate.nextInt(15);
		int generateTwo = rndGenerateTwo.nextInt(11);
		if(generate==generateTwo && this.battery>10)
		{
			System.out.print("совершить звонок");
			Calling();
			this.battery-=3;
		} 
		return;
	}
	public void Calling()
	{
		this.phonebook = new String [] {"Bob","Iren","Claus","Zorg"};
		this.phonenumbers = new int []{0677777777,342574,25055057,429234};
		int i ,phonebook1 = this.phonebook.length;
		Random rnd1 = new Random();
		int sh = rnd1.nextInt(this.phonebook.length);
		for(i = 0;i < phonebook1;i++)
		{
			this.phonebook[i]+="\t"+phonenumbers[i];
		}
			System.out.println();
			Arrays.sort(this.phonebook);
			System.out.println(this.phonebook[sh]);	
	}
	
	public void showoperator()
	
	{
		this.operator = new String [] {"KYIVSTAR ","VODAFONE"};
		for(int i=0; i<this.operator.length; i++)
		{
			System.out.print(this.operator[i]);
		}
		System.out.println();
	}
	public void incomingСall()
	{
		Random rndGenerate = new Random();
		Random rndGenerateTwo = new Random();
		int generate = rndGenerate.nextInt(15);
		int generateTwo = rndGenerateTwo.nextInt(16);
		if(generate==generateTwo)
		{
			System.out.println(this.ring);
			Calling();
			answer();
		} 
		return;
	}
	public void answer()
	{
		Random rndGenerateAns = new Random();
		this.call = rndGenerateAns.nextInt(2);
		if(this.call ==1 && this.battery>10)
		{
			System.out.println("Принять");
			this.battery-=3;
		}else System.out.println("Отклонить");
		return;
	}
	
	
	
	

	
		

}