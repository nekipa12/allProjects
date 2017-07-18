package Chuwaki;
import java.util.Scanner;

public class PeopleWeight {
	private String name;
	private double weight;
	Scanner sc = new Scanner(System.in);
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double d) {
		this.weight = d;
	}
	public void method(String name, double weight){
		setName(sc.nextLine());
		setWeight(sc.nextDouble());
		
	}
	public PeopleWeight(String name, double weight) {
		method(name, weight);
		
	}
	
	@Override
	public String toString() {
		return "name= " + name + ", weight= " + weight;
	}
	public void methodMoon(PeopleWeight[] data){
		
			double moonG = getWeight()*0.17;
			setWeight(moonG);
		
		
	}
	public static void main(String[] args) {
		
		PeopleWeight[] data = new PeopleWeight[5];
		for(int i = 0; i < data.length; i++) {
			try {
				data[i] = new PeopleWeight("", 0);
			}catch(Exception e) {
				System.out.println("Введи корректное значение");
				i--; 
			}
		}
		for(int i = 0; i< data.length;i++ ) {
			System.out.println(data[i].toString());
		}
		System.out.println("Вес на луне составит 17% от веса не земле");
		for(int i = 0; i< data.length;i++ ) {
			data[i].methodMoon(data);
			System.out.println(data[i].toString());
		}
	}
}
