package Question1_7;

import CtCILibrary.AssortedMethods;

public class Question {
	
	public static void ylSetZero(int[][] matrix) {
		int length = matrix.length;
		int width = matrix[0].length;
		boolean[] row = new boolean[length];
		boolean[] col = new boolean[width];
		
		for (int i=0; i<length; i++) {
			for (int j=0; j<width; j++) {
				if (matrix[i][j]==0) {
					row[i]=true;
					col[j]=true;
				}
			}
		}
		
		for (int i=0; i<length; i++) {
		    for (int j=0; j<width; j++) {
		        if (row[i]||col[j]) {
		            matrix[i][j]=0;
		        }
		    }
		}
	}
	
	
	
	
	public static void setZeros(int[][] matrix) {
		boolean[] row = new boolean[matrix.length];	
		boolean[] column = new boolean[matrix[0].length];

		// Store the row and column index with value 0
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length;j++) {
				if (matrix[i][j] == 0) {
					row[i] = true; 
					column[j] = true;
		 		}
			}
		}

		// Set arr[i][j] to 0 if either row i or column j has a 0
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (row[i] || column[j]) {
					matrix[i][j] = 0;
				}
			}
		}
	}	
	
	public static void main(String[] args) {
		int[][] matrix = AssortedMethods.randomMatrix(3, 5, 0, 5);
		AssortedMethods.printMatrix(matrix);
		//setZeros(matrix);
		ylSetZero(matrix);
		System.out.println();
		System.out.println();
		AssortedMethods.printMatrix(matrix);
	}

}
