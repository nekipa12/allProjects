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
			System.out.println("�������������� GRN-USD ");
			System.out.print("������� �-�� �������������� GRN = ");
		double usd = sc.nextDouble();
			if (usd == 0) 
			{
				sc.close();
				return;
			}
			System.out.println( "�-�� ���������� USD = "+ usd * b );
			System.out.println("");
			System.out.println("������� 0 ���� ������ ����� ");
			System.out.println("");
			System.out.println( "�������������� USD-GRN " );
			System.out.print("������� �-�� �������������� USD = ");
			System.out.print("");
		double grn = sc.nextDouble();
			if (grn == 0) 
			{
				sc.close();
				return;
			}
			System.out.print( "�-�� ���������� GRN = " + grn * a );
		}
	}
}
