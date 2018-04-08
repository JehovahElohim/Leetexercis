package leetcode;

import java.util.Arrays;

public class MaximalSquare {
	public int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return 0;
		}
		// 表示以[i][j]的点为右下角的矩阵时，最大的矩阵的边长。
		int max = -1;
		int dp[][] = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i] = matrix[0][i] - '0';
			max = Math.max(max, dp[0][i]);
		}
		for (int i = 1; i < dp.length; i++) {
			dp[i][0] = matrix[i][0] - '0';
			max = Math.max(max, dp[i][0]);
		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (matrix[i][j] == '0')
					dp[i][j] = 0;
				else {
					int m = Math.min(dp[i - 1][j], dp[i][j - 1]);
					if (m == 0)
						dp[i][j] = matrix[i][j] - '0';
					else {
						if (matrix[i - m][j - m] == '1')
							dp[i][j] = m + 1;
						else
							dp[i][j] = m;
					}
				}
				max = Math.max(max, dp[i][j]);
			}

		}
		for (int i = 0; i < dp.length; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
		return max * max;
	}
}
