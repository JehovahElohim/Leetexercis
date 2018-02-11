package _12_;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0.
 * Do it in place. 如果一个元素为0，将他所在的列和排设置为0.不用额外空间
 * 
 * 这道题的要求是用O(1)的空间，那么我们就不能新建数组，我们考虑就用原数组的第一行第一列来记录各行各列是否有0.
 * 
 * - 先扫描第一行第一列，如果有0，则将各自的flag设置为true - 然后扫描除去第一行第一列的整个数组，如果有0，则将对应的第一行和第一列的数字赋0
 * - 再次遍历除去第一行第一列的整个数组，如果对应的第一行和第一列的数字有一个为0，则将当前值赋0 - 最后根据第一行第一列的flag来更新第一行第一列
 * 
 * @author asus pc
 *
 */
public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		int x = matrix[0].length, y = matrix.length;
		boolean rowFlag = false, colFlag = false;
		for (int i = 0; i < x; i++) {
			if (matrix[0][i] == 0) {
				rowFlag = true;
				break;
			}
		}
		for (int i = 0; i < y; i++) {
			if (matrix[i][0] == 0) {
				colFlag = true;
				break;
			}
		}
		for (int i = 1; i < y; i++) {
			for (int j = 1; j < x; j++) {
				if (matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		System.out.println(colFlag);
		System.out.println(rowFlag);
		for (int i = 0; i < x; i++) {
			System.out.print(matrix[0][i] + " ");
		}
		System.out.println();
		for (int i = 0; i < y; i++) {
			System.out.print(matrix[i][0] + " ");
		}
		for (int i = 1; i < x; i++) {
			if (matrix[0][i] == 0) {
				for (int j = 0; j < y; j++) {
					matrix[j][i] = 0;
				}
			}
		}
		for (int i = 1; i < y; i++) {
			if (matrix[i][0] == 0) {
				for (int j = 0; j < x; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		if (colFlag) {
			for (int j = 0; j < y; j++) {
				matrix[j][0] = 0;
			}
		}
		if (rowFlag) {
			for (int j = 0; j < x; j++) {
				matrix[0][j] = 0;
			}
		}
	}

	public static void main(String args[]) {
		new SetMatrixZeroes()
				.setZeroes(new int[][] { 
						{ 0, 0, 0, 5 }, 
						{ 4, 3, 1, 4 },
						{ 0, 1, 1, 4 },
						{ 1, 2, 1, 3 }, 
						{ 0, 0, 1, 1 } });

	}
}
