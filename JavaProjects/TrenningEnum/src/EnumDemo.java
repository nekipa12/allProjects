
public class EnumDemo {

	public static void main(String[] args) {
		
		Apple ap;
		Apple allapples [] = Apple.values();
		for(Apple a : allapples)
			System.out.println(a);
		for(Apple a:Apple.values())
		System.out.println(a);
		
		System.out.println();
		ap=Apple.valueOf("Winesap");
		System.out.println(ap);

	}

}
