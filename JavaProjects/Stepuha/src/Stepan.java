import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class Stepan {
	private String familiya;
	private String name;
	private String otchstvo;
	private String group;
	private int [] si;
	
	public String getFamiliya() {
		return familiya;
	}

	public void setFamiliya(String familiya) {
		this.familiya = familiya;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOtchstvo() {
		return otchstvo;
	}

	public void setOtchstvo(String otchstvo) {
		this.otchstvo = otchstvo;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	

	public int[] getSi() {
		return si;
	}

	public void setSi(int[] si) {
		this.si = si;
	}

	public Stepan(String group, String familiya, String name, String otchstvo, int [] si) {
		this.familiya = familiya;
		this.name = name;
		this.otchstvo = otchstvo;
		this.group = group;
		this.si = si;
	}
	
	@Override
	public String toString() {
		return "Stepan [familiya=" + familiya + ", name=" + name + ", otchstvo=" + otchstvo + ", group=" + group
				+ ", si=" + si + "]";
	}

	void sr(){
		Scanner sc = new Scanner(System.in);
	}
	public static void main(String[] args) {
		int[] si = new int[]{5,4,5,4};
		
		ArrayList<Stepan> s = new ArrayList<>();
		s.add(new Stepan("IT", "A", "A", "A", si));
		s.add(new Stepan("IT", "B", "B", "B", si));
		s.add(new Stepan("IT", "C", "C", "C", si));
		s.add(new Stepan("IT", "D", "D", "D", si));
		s.add(new Stepan("IT", "E", "E", "E", si));
		s.add(new Stepan("IT", "F", "F", "F", si));
		s.add(new Stepan("IT", "G", "G", "G", si));
		s.add(new Stepan("IT", "H", "H", "H", si));
		
		for(Stepan st : s){
			st.si.length
		}
		
		int[] a = new int[s.size()];
		for( int i = 0; i< s.size(); i++){
			a = s.get(i).si.values().;
		}	
		for( int i = 0; i< a.length; i++){
			System.out.println(a);
		}
		
	}
}
