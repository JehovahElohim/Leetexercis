package leetcode;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to
 * n2 in spiral order.
 * 
 * For example, Given n = 3,
 * 
 * You should return the following matrix: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5
 * ] ]
 * 
 * @author asus pc
 *
 */
public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
		int[][] res = new int[n][n];
		int count = 1;
		for (int i = 0; i < (n + 1) / 2; i++) {
			for (int j = i; j < n - i; j++) {
				res[i][j] = count++;
				
			}
			for (int j = i; j < n - i - 1; j++) {
				res[j+1][n - i - 1] = count++;
			}
			for (int j = i+1; j < n - i; j++) {
				res[n - i - 1][n - j - 1] = count++;
			}
			for (int j = i; j < n - i - 2; j++) {
				res[n - j - 2][i] = count++;
			}
			
		}
		return res;
	}

	public static void main(String args[]) {
		new SpiralMatrixII().generateMatrix(1);
	}
}
