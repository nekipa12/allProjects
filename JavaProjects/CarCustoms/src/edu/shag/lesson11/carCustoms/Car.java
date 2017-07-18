package edu.shag.lesson11.carCustoms;

public class Car {

	class Engine{
		
		private String type;
		private int numberOfCylinders;
		private int power;
		public Engine(){}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public int getNumberOfCylinders() {
			return numberOfCylinders;
		}
		public void setNumberOfCylinders(int numberOfCylinders) {
			this.numberOfCylinders = numberOfCylinders;
		}
		public int getPower() {
			return power;
		}
		public void setPower(int power) {
			this.power = power;
		}
		
		public Engine(String type, int numberOfCylinders, int power) {
			this.type = type;
			this.numberOfCylinders = numberOfCylinders;
			this.power = power;
		}
		
		@Override
		public String toString() {
			return "Engine type : " + type + ", numberOfCylinders : " + numberOfCylinders + ", power : " + power + "\n";
		}
		
	}
	
	class GearBox{
		
		private boolean automaticTransmission;
		private int numberOfGears;
		public GearBox(){}
		
		public boolean isAutomaticTransmission() {
			return automaticTransmission;
		}
		public void setAutomaticTransmission(boolean automaticTransmission) {
			this.automaticTransmission = automaticTransmission;
		}
		public int getNumberOfGears() {
			return numberOfGears;
		}
		public void setNumberOfGears(int numberOfGears) {
			this.numberOfGears = numberOfGears;
		}
		
		public GearBox(boolean automaticTransmission, int numberOfGears) {
			this.automaticTransmission = automaticTransmission;
			this.numberOfGears = numberOfGears;
		}
		
		@Override
		public String toString() {
			return "GearBox automaticTransmission : " + automaticTransmission + ", numberOfGears : " + numberOfGears+"\n";
		}
		
	}
	
	class Wheels{
		
		private int wheelSize;
		private String typeWheel;
		public Wheels(){}
		
		public int getWheelSize() {
			return wheelSize;
		}
		public void setWheelSize(int wheelSize) {
			this.wheelSize = wheelSize;
		}
		public String isTypeWheel() {
			return typeWheel;
		}
		public void setTypeWheel(String typeWheel2) {
			this.typeWheel = typeWheel2;
		}
		
		public Wheels(int wheelSize, String typeWheel) {
			this.wheelSize = wheelSize;
			this.typeWheel = typeWheel;
		}

		@Override
		public String toString() {
			return "Wheels wheelSize : " + wheelSize + ", typeWheel : " + typeWheel + "\n";
		}
		
	}
	
	class FuelTunk{
		
		private int capacity;
		public FuelTunk(){}
		
		public int getCapacity() {
			return capacity;
		}
		public void setCapacity(int capacity) {
			this.capacity = capacity;
		}

		public FuelTunk(int capacity) {
			this.capacity = capacity;
		}

		@Override
		public String toString() {
			return "FuelTunk capacity : " + capacity + "\n";
		}
		
		
	}
	
	class BodyType{
		
		private boolean pickup;
		public BodyType(){}
		
		public boolean isPickup() {
			return pickup;
		}
		public void setPickup(boolean pickup) {
			this.pickup = pickup;
		}
		
		public BodyType(boolean pickup) {
			this.pickup = pickup;
		}

		@Override
		public String toString() {
			return "BodyType pickup : " + pickup + "\n";
		}
		
		
	}
	
	
	private Engine engine;
	private GearBox gearBox;
	private Wheels wheels;
	private FuelTunk fuelTunk;
	private BodyType bodyType;
	private String name;
	private int maxSpeed;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	public void setEngine(String type, int numberOfCylinders, int power) {
		this.engine = new Engine();
		this.engine.setType(type);
		this.engine.setNumberOfCylinders(numberOfCylinders);
		this.engine.setPower(power);
	}
	public void setGearBox(boolean automaticTransmission, int numberOfGears) {
		this.gearBox = new GearBox();
		this.gearBox.setAutomaticTransmission(automaticTransmission);
		this.gearBox.setNumberOfGears(numberOfGears);
	}
	public void setWheels(int wheelSize, String typeWheel) {
		this.wheels = new Wheels();
		this.wheels.setWheelSize(wheelSize);
		this.wheels.setTypeWheel(typeWheel);
	}
	public void setFuelTunk(int capacity) {
		this.fuelTunk = new FuelTunk();
		this.fuelTunk.setCapacity(capacity);
	}
	public void setBodyType(boolean pickup) {
		this.bodyType = new BodyType();
		this.bodyType.setPickup(pickup);
	}

	public Car(String name, int maxSpeed) {
		this.name = name;
		this.maxSpeed = maxSpeed;
		setEngine("Diesel", 6, 550);
		setGearBox(true, 6);
		setWheels(22, "Stamped");
		setFuelTunk(40);
		setBodyType(false);
	}
	
	@Override
	public String toString() {
		return engine.toString() + "\n" + gearBox.toString() + "\n"+wheels.toString() + "\n" 
									+ fuelTunk.toString() + "\n" + bodyType.toString() + "\n"
									+ "Name : " + name + "\n" + "Max speed : " + maxSpeed;
	}
	
	public static void main(String[] args) 
	{
		Car aCar = new Car("Chevrolet", 260);
		System.out.println(aCar.toString());
	}
}
