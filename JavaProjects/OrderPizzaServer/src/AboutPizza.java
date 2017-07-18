import java.io.File;
import java.util.ArrayList;

public class AboutPizza {
	private int price;
	private String name;
	private File f;
	
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public File getF() {
		return f;
	}

	public void setF(File f) {
		this.f = f;
	}

	public AboutPizza(int price, String name, File f) {
		this.price = price;
		this.name = name;
		this.f = f;
	}
	
	public static ArrayList<AboutPizza> pizza(){
		String name = "American";
		AboutPizza ap = new AboutPizza(138, name, new File(name + ".html"));
		String name1 = "BBQ";
		AboutPizza ap1 = new AboutPizza(140, name1, new File(name1 + ".html"));
		String name2 = "Havaii";
		AboutPizza ap2 = new AboutPizza(138, name2, new File(name2 + ".html"));
		String name3 = "Marena";
		AboutPizza ap3 = new AboutPizza(148, name3, new File(name3 + ".html"));
		String name4 = "Margarita";
		AboutPizza ap4 = new AboutPizza(138, name4, new File(name4 + ".html"));
		String name5 = "Ohoth";
		AboutPizza ap5 = new AboutPizza(120, name5, new File(name5 + ".html"));
		String name6 = "Portabella";
		AboutPizza ap6 = new AboutPizza(122, name6, new File(name6 + ".html"));
		String name7 = "Verona";
		AboutPizza ap7 = new AboutPizza(128, name7, new File(name7 + ".html"));
		ArrayList<AboutPizza> alap = new ArrayList<>();
		alap.add(ap);
		alap.add(ap1);
		alap.add(ap2);
		alap.add(ap3);
		alap.add(ap4);
		alap.add(ap5);
		alap.add(ap6);
		alap.add(ap7);
		
		return alap;
		
	}
	
	
	
}
