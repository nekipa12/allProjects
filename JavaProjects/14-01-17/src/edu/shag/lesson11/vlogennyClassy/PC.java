package edu.shag.lesson11.vlogennyClassy;

public class PC {
	
	class CPU {
		private String architecture;
		private int frequency;
		private int cache;
		public CPU(){}
		public String getArchitecture() {
			return architecture;
		}
		public void setArchitecture(String architecture) {
			this.architecture = architecture;
		}
		public int getFrequency() {
			return frequency;
		}
		public void setFrequency(int frequency) {
			this.frequency = frequency;
		}
		public int getCache() {
			return cache;
		}
		public void setCache(int cache) {
			this.cache = cache;
		}
		
		public CPU(String architecture, int frequency, int cache) {
			super();
			this.architecture = architecture;
			this.frequency = frequency;
			this.cache = cache;
		}
		
		@Override
		public String toString() {
			return "CPU architecture=" + architecture + ", frequency="
					+ frequency + ", cache=" + cache;
		}
		
		
	}
	
	class VideoCard {
		private String architecture;
		private int frequency;
		private double memory;
		public VideoCard(){}
		public String getArchitecture() {
			return architecture;
		}
		public void setArchitecture(String architecture) {
			this.architecture = architecture;
		}
		public int getFrequency() {
			return frequency;
		}
		public void setFrequency(int frequency) {
			this.frequency = frequency;
		}
		public double getMemory() {
			return memory;
		}
		public void setMemory(double memory) {
			this.memory = memory;
		}
		
		public VideoCard(String architecture, int frequency, double memory) {
			super();
			this.architecture = architecture;
			this.frequency = frequency;
			this.memory = memory;
		}
		
		@Override
		public String toString() {
			return "VideoCard architecture=" + architecture + ", frequency="
					+ frequency + ", memory=" + memory;
		}
		
	}
	
	class MotherBoard {
		private String socket;
		private String chipset;
		private String vendor;
		public MotherBoard (){}
 		public String getSocket() {
			return socket;
		}
		public void setSocket(String socket) {
			this.socket = socket;
		}
		public String getChipset() {
			return chipset;
		}
		public void setChipset(String chipset) {
			this.chipset = chipset;
		}
		public String getVendor() {
			return vendor;
		}
		public void setVendor(String vendor) {
			this.vendor = vendor;
		}
		
		public MotherBoard(String socket, String chipset, String vendor) {
			super();
			this.socket = socket;
			this.chipset = chipset;
			this.vendor = vendor;
		}
		
		@Override
		public String toString() {
			return "MotherBoard socket=" + socket + ", chipset=" + chipset
					+ ", vendor=" + vendor;
		}
		
	}
	
	private CPU cpu;
	private VideoCard video;
	private MotherBoard mother;
	int powerSupply;
	
	
	public CPU getCpu() {
		return cpu;
	}
	public void setCpu(String architecture, int frequency, int cache ) {
		this.cpu=new CPU();
		this.cpu.setArchitecture(architecture);
		this.cpu.setFrequency(frequency);
		this.cpu.setCache(cache);
	}
	public VideoCard getVideo() {
		return video;
	}
	public void setVideo(String architecture, int frequency, double memory ) {
		this.video= new VideoCard();
		this.video.setArchitecture(architecture);
		this.video.setFrequency(frequency);
		this.video.setMemory(memory);
	}
	public MotherBoard getMother() {
		return mother;
	}
	public void setMother(String socket,String chipset , String vendor ) {
		this.mother= new MotherBoard();
		this.mother.setSocket(socket);
		this.mother.setChipset(chipset);
		this.mother.setVendor(vendor);
	}
	public int getPowerSupply() {
		return powerSupply;
	}
	public void setPowerSupply(int powerSupply) {
		this.powerSupply = powerSupply;
	}


	public PC(int powerSupply) {
		this.powerSupply = powerSupply;
		setCpu("Fa", 10, 5);
		setVideo("Z", 11, 15.5);
		setMother("a", "b", "c");
		
	}
	
	
	@Override
	public String toString() {
		return cpu.toString() + "\n	" + video.toString() + "\n	" + mother.toString()
				+ "	\n	" + powerSupply;
	}
	
	public static void main(String[] args) {
		
		PC aPC = new PC(650);
		System.out.println(aPC.toString());
		
	}
	
	
	

}

















