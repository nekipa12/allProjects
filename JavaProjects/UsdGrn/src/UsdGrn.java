import java.util.Scanner;
public class UsdGrn 
{
	public static void main(String[] args) 
	{
		double a = 26.8;
		double b = 1 / a;
		Scanner sc;
		sc = new Scanner(System.in);
		while (true) 
		{
			System.out.println("");
			System.out.println("Конвертировать GRN-USD ");
			System.out.print("Введите к-во конвертируемых GRN = ");
		double usd = sc.nextDouble();
			if (usd == 0) 
			{
				sc.close();
				return;
			}
			System.out.println( "К-во получаемых USD = "+ usd * b );
			System.out.println("");
			System.out.println("Введите 0 если хотите выйти ");
			System.out.println("");
			System.out.println( "Конвертировать USD-GRN " );
			System.out.print("Введите к-во конвертируемых USD = ");
			System.out.print("");
		double grn = sc.nextDouble();
			if (grn == 0) 
			{
				sc.close();
				return;
			}
			System.out.print( "К-во получаемых GRN = " + grn * a );
		}
	}
}
