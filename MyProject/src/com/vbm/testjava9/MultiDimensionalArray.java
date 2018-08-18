package com.vbm.testjava9;

public class MultiDimensionalArray {

	static void displayElements(int[][] matrix) {
		for (int[] is : matrix) {
			for (int i : is) {
				System.out.print(" " + i);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		int[][] myFirstArray = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		int[][] mySecondArray = { { 9, 8, 7 }, { 6, 5, 4 }, { 3, 2, 1 } };

		System.out.println("Matrix A elements");
		displayElements(myFirstArray);
		System.out.println("Matrix B elements");
		displayElements(mySecondArray);

		multiplyMatrix(myFirstArray, mySecondArray);
	}

	private static void multiplyMatrix(int[][] myFirstArray, int[][] mySecondArray) {
		int[][] productMatrix = new int[3][3];
		for (int i = 0; i < myFirstArray.length; i++)
			for (int j = 0; j < myFirstArray[i].length; j++) {
				productMatrix[i][j] = 0;
				for (int k = 0; k < myFirstArray[i].length; k++) {
					productMatrix[i][j] += myFirstArray[i][k] * mySecondArray[k][j];
				}
			}
		System.out.println("\nProduct of matrix is");
		displayElements(productMatrix);
	}
}
