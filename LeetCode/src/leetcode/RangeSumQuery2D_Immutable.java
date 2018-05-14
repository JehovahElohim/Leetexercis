package leetcode;


public class RangeSumQuery2D_Immutable {

	int dp[][];

	public RangeSumQuery2D_Immutable(int[][] matrix) {
		if (matrix != null&&matrix.length!=0) {
			dp = new int[matrix.length][matrix[0].length];
			dp[0][0] = matrix[0][0];
			for (int i = 1; i < matrix.length; i++) {
				dp[i][0] = dp[i - 1][0] + matrix[i][0];
			}
			for (int i = 1; i < matrix[0].length; i++) {
				dp[0][i] = dp[0][i - 1] + matrix[0][i];
			}
			for (int i = 1; i < matrix.length; i++) {
				for (int j = 1; j < matrix[0].length; j++) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + matrix[i][j]
							- dp[i - 1][j - 1];
				}
			}
		}

	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		if(dp==null)
			return 0;
		if(row1==0&&col1==0)
			return dp[row2][col2];
		if(row1==0)
			return  dp[row2][col2] - dp[row2][col1 - 1];
		if(col1==0)
			return  dp[row2][col2] -  dp[row1 - 1][col2];
		return dp[row2][col2] - dp[row1 - 1][col2] - dp[row2][col1 - 1]
				+ dp[row1 - 1][col1 - 1];
	}
}
