package _12_;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * @author asus pc 思路：动态规划 该格子的最小数等于 min（上格子最小数，左格子最小数）
 */
public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		if (grid.length == 0 || grid[0].length == 0)
			return 0;
		int x = grid.length, y = grid[0].length;
		int res[][] = new int[x][y];
		res[0][0] = grid[0][0];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (i == 0) {
					if (j == 0)
						continue;
					res[i][j] = res[i][j - 1] + grid[i][j];
				} else if (j == 0) {
					res[i][j] = res[i - 1][j] + grid[i][j];
				} else {
					res[i][j] = Math.min(res[i - 1][j], res[i][j - 1])
							+ grid[i][j];
				}
			}
		}
		return res[x-1][y-1];
	}
}
