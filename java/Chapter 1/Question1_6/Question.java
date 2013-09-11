package Question1_6;

import CtCILibrary.*;

public class Question {

	/*
	 * not really understand how the index changes
	 * could start with one example to understand the index changes
	 */
	public static void ylRotate(int[][] matrix, int n) {
		for (int i=0; i<(n/2); i++) {
			for (int j=0; j<(n+1)/2; j++)
			{
				int tmp = matrix[i][j];
				matrix[i][j]= matrix[n-1-j][i];
				matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
				matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
				matrix[j][n-1-i] = tmp;
			}
		}
	}
	
	private static void exchange(int a, int b, int c, int d) {
		int tmp =a;
		a=b;
		b=c;
		c=d;
		d=tmp;
	}
	
	public static void rotate(int[][] matrix, int n) {
		for (int layer = 0; layer < n / 2; ++layer) {
			int first = layer;
			int last = n - 1 - layer;
			for(int i = first; i < last; ++i) {
				int offset = i - first;
				int top = matrix[first][i]; // save top

				// left -> top
				matrix[first][i] = matrix[last-offset][first]; 			

				// bottom -> left
				matrix[last-offset][first] = matrix[last][last - offset]; 

				// right -> bottom
				matrix[last][last - offset] = matrix[i][last]; 

				// top -> right
				matrix[i][last] = top; // right <- saved top
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = AssortedMethods.randomMatrix(5, 5, 0, 9);
		AssortedMethods.printMatrix(matrix);
		//rotate(matrix, 5);
		ylRotate(matrix, 5);
		System.out.println();
		AssortedMethods.printMatrix(matrix);
	}

}
