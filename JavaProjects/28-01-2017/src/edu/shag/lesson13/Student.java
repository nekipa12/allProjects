package edu.shag.lesson13;

import java.util.PriorityQueue;

public class Student implements Comparable<Student> {
	String name;
	String speciality;
	double avg;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	
	public Student(String name, String speciality, double avg) {
		
		this.name = name;
		this.speciality = speciality;
		this.avg = avg;
	}
	
	@Override
	public String toString() {
		return "name=" + name + ", speciality=" + speciality
				+ ", avg=" + avg;
	}

	public static void main(String[] args) {
		PriorityQueue<Student> q = new PriorityQueue<>();
		q.offer(new Student("Kol", "Comp", 2.5));
		q.offer(new Student("Aol", "Comp", 4.5));
		q.offer(new Student("Wnna", "Comp", 5.0));
		while (!q.isEmpty()){
		System.out.println(q.poll());
		}
	}
	

	@Override
	public int compareTo(Student o) {
		if(this.name.compareTo(o.name)<0) return -1;
		else if(this.name.compareTo(o.name)>0) return 1;
		else if (this.avg< o.avg) return -1;
		else if (this.avg> o.avg) return 1;
		else return 0;
	}

}
