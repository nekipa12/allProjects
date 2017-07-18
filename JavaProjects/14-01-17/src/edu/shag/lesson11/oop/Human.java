package edu.shag.lesson11.oop;

public abstract class Human {
	
	private String name;
	private int age;
	/**
	 * способности от 0 до 100
	 */
	private int skill;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSkill() {
		return skill;
	}
	public void setSkill(int skill) {
		this.skill = skill;
	}
	
	public Human(String name, int age, int skill) {
		this.name = name;
		this.age = age;
		this.skill = skill;
	}
	
	
	@Override
	


	public String toString() {
		return "name=" + name + ", age=" + age + ", skill=" + skill
				+ "]";
	}
	
	abstract public void play();
	
}
