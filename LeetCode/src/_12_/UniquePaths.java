package _12_;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * How many possible unique paths are there?
 * 
 * @author asus pc 思路：动态规划 该点的路径数等于 以上面一个格子为终点的路径数和以左边一个格子为重点的路径数的和
 */
public class UniquePaths {
	public int uniquePaths(int m, int n) {
		int[][] total = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n ; j++) {
				if (i == 0 || j == 0) {
					total[i][j] = 1;
				} else
					total[i][j] = total[i - 1][j] + total[i][j - 1];
			}
		}
		return total[m - 1][n - 1];
	}

	public static void main(String args[]) {
		new UniquePaths().uniquePaths(2, 2);
	}
}
