package _12_;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 * 
 * For example, Given the following matrix:
 * 
 * [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ] You should return
 * [1,2,3,6,9,8,7,4,5].
 * 
 * @author asus pc
 *
 */
public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new LinkedList<>();
		if (matrix.length == 0) {
			return list;
		}
		int height = matrix.length;
		int width = matrix[0].length;
		int n = (Math.min(height, width)+1)/2;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < width - i; j++) {
				System.out.println(1);
				list.add(matrix[i][j]);
			}
			for (int j = i; j < height - i - 1; j++) {
				System.out.println(2);
				list.add(matrix[j + 1][width - 1 - i]);
			}
			if (height - i - 1 != i) {
				for (int j = i; j < width - i - 1; j++) {
					System.out.println(3);
					list.add(matrix[height - 1 - i][width - j - 2]);
				}
			}
			if (width - i - 1 != i) {
				for (int j = i; j < height - i - 2; j++) {
					System.out.println(4);
					list.add(matrix[height - j - 2][i]);
				}
			}
		}
		for (Integer integer : list) {
			System.out.print(integer + " ");
		}
		return list;
	}

	public static void main(String args[]) {
		new SpiralMatrix()
				.spiralOrder(new int[][] { { 2, 5, 8 }, { 4, 0, -1 } });
	}
}
