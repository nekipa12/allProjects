
import java.util.Random;


public class Matrix 
{

	public static void main(String[] args) 
	{
				int [][] matr = new int [5][6];
		        
		        Random rnd = new Random();

		        for (int i = 0; i<matr.length; i++)
		        {
		            for (int j = 0; j<matr[i].length; j++)
		            {
		                matr[i][j] = rnd.nextInt(20);
		                System.out.print(matr[i][j] + "\t");
		            }
		            System.out.println();
		        }
		        System.out.println();
		        for (int i = 0; i< matr.length; i++)
		        {
		            for (int j = 0; j < matr[i].length; j+=2)
		            {
		                int z = j, val1=matr[i][j],val2= matr[i][++z];
		                matr[i][j] = val2;
		                matr[i][z] = val1;
		            }
			        for (int j = 0; j < matr[i].length; j++)
			        {
			        	System.out.print(matr[i][j] + "\t");
			        }
			        System.out.println();
		        }    
	}
}

