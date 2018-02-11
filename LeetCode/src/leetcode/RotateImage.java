package leetcode;

/**
 * You are given an n x n 2D matrix representing an image.
 * 
 * Rotate the image by 90 degrees (clockwise).
 * 
 * Note: You have to rotate the image in-place, which means you have to modify
 * the input 2D matrix directly. DO NOT allocate another 2D matrix and do the
 * rotation.
 * 
 * Example 1:
 * 
 * Given input matrix = [ [1,2,3], [4,5,6], [7,8,9] ],
 * 
 * rotate the input matrix in-place such that it becomes: [ [7,4,1], [8,5,2],
 * [9,6,3] ]
 * 
 * @author asus pc
 *
 */
public class RotateImage {
	public void rotate(int[][] matrix) {
		for (int i = 0; i < matrix.length / 2; i++) {
			for (int j = i; j < matrix.length - 1 - i; j++) {
				int temp = matrix[j][matrix.length - i - 1];// 1 2 1 1
				int ii = i;
				int jj = j;
				for (int j2 = 0; j2 < 4; j2++) {
					if (j2 == 3) {
						matrix[jj][matrix.length - ii - 1] = temp;
					} else {
						matrix[jj][matrix.length - ii - 1] = matrix[ii][jj];
						int t1 = ii;
						ii = matrix.length - jj - 1;
						jj = t1;
					}
				}
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String args[]) {
		new RotateImage().rotate(new int[][] { 
				{ 5, 1, 9, 11 },
				{ 2, 4, 8, 10 },
				{ 13, 3, 6, 7 },
				{ 15, 14, 12, 16 } });
	}

}
