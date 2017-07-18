import java.util.Scanner;

public class Poops {

	public static void main(String[] args) {
		
		int matrix[][] = new int [10][10];
		
		for(int i = 1; i < matrix.length; i++){
			for(int j = 1; j < matrix[i].length; j++){
				matrix[i][j] = i;
				int c = i * j;
				System.out.print(j + " * " + i + " = " + c + "\t");
			}
			System.out.println();
		}
				
		
		
		
		
	}

}
