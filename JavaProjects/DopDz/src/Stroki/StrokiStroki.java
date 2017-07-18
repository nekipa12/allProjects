package Stroki;

import java.util.Scanner;

public class StrokiStroki 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String g = sc.nextLine();
		String[] words = g.split("\\s");
		
		int wordCount = 0; 
		int i, wordsSize = words.length;
	    for (i = 0; i < wordsSize; ++i)
	    {
	    	if (words[i] != null && !"".equals(words[i]))
	    	{
	    		 ++wordCount;
	    	}	 
	    }	
	    System.out.println(" оличество слов = " +"\t"+"\t"+ wordCount);
	    sc.close(); 
	    String h = g, 
	    h = g.replaceAll("[^ајоќи»е≈Є®эЁыџу”юё€я]", "");
	    System.out.println(" оличество гласных букв = "+"\t"+h.length());
	    g = g.replaceAll("[^бЅв¬г√дƒж∆з«й…к лЋмћнЌпѕр–с—т“ф‘х’ц÷ч„шЎщў]", "");
	    System.out.println(" оличество согласных букв = "+"\t"+g.length());
	    
	}

}
