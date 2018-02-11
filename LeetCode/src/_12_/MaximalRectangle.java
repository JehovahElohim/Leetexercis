package _12_;

/**
 * 
 * @author asus pc
 *         https://leetcode.com/problems/maximal-rectangle/discuss/29054/
 *         Share-my-DP-solution
 *         思路：找每个可以构成的面积，构造3个矩阵。由矩阵计算面积，从而得出最大值。
 */
public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
		if (matrix.length == 0)
			return 0;
		int h = matrix.length;
		int l = matrix[0].length;
		int heights[][] = new int[h][l];
		int left[][] = new int[h][l];
		int right[][] = new int[h][l];
		int max = 0;
		for (int i = 0; i < h; i++) {
			int leftBorder = 0, rightBorder = l;
			for (int j = 0; j < l; j++) {
				heights[i][j] = matrix[i][j] == '0' ? 0 : (i == 0 ? 1
						: heights[i - 1][j] + 1);
				if (matrix[i][j] == '0') {
					leftBorder = j + 1;
				} else {
					if (i == 0)
						left[i][j] = leftBorder;
					else
						left[i][j] = Math.max(left[i - 1][j], leftBorder);
				}
			}
			for (int j = l - 1; j >= 0; j--) {
				if (matrix[i][j] == '0') {
					right[i][j] = l;
					rightBorder = j;
				} else {
					if (i == 0)
						right[i][j] = rightBorder;
					else
						right[i][j] = Math.min(right[i - 1][j], rightBorder);
				}
			}
			for (int j = 0; j < l; j++) {
				max = Math.max(max, heights[i][j] * (right[i][j] - left[i][j]));
			}

		}
		// for (int i = 0; i < h; i++) {
		// for (int j = 0; j < l; j++) {
		// System.out.print(left[i][j] + " ");
		// }
		// System.out.println();
		// }System.out.println();
		// for (int i = 0; i < h; i++) {
		// for (int j = 0; j < l; j++) {
		// System.out.print(right[i][j] + " ");
		// }
		// System.out.println();
		// }
		// System.out.println(max);
		return max;
	}

	public static void main(String args[]) {
		new MaximalRectangle().maximalRectangle(new char[][] {
				{ '0', '1', '1', '1', '1', '1', '0' },
				{ '0', '0', '1', '1', '1', '0', '0' },
				{ '0', '0', '0', '1', '0', '0', '0' } });
	}
}
