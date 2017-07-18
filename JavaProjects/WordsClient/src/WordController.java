import java.util.Scanner;


public class WordController {

	Scanner keyboard;

	public WordController() {
		keyboard = new Scanner(System.in);
	}
	
	public String check(String word){
		String w = null;
		while(true){
			System.out.println(word);
			System.out.println("Enter word which starts from " + word.charAt(word.length()-1));
			w = keyboard.nextLine();
			if(w.charAt(0) == word.charAt(word.length()-1)){
				break;
				
			}
		}
		return w;
	}

	public String nextWord() {
		return keyboard.nextLine();
	}
}
