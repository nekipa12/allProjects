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
	    System.out.println("���������� ���� = " +"\t"+"\t"+ wordCount);
	    sc.close(); 
	    String h = g, 
	    h = g.replaceAll("[^�������Ÿ�����������]", "");
	    System.out.println("���������� ������� ���� = "+"\t"+h.length());
	    g = g.replaceAll("[^������������������������������������������]", "");
	    System.out.println("���������� ��������� ���� = "+"\t"+g.length());
	    
	}

}
