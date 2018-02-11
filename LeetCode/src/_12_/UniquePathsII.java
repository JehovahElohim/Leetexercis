package _12_;

import java.util.Arrays;

/**
 * Follow up for "Unique Paths":
 * 
 * Now consider if some obstacles are added to the grids. How many unique paths
 * would there be?
 * 
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * For example, There is one obstacle in the middle of a 3x3 grid as illustrated
 * below.
 * 
 * @author asus pc 与UNIQUE PATH一样 不过不能走的部分用0填充
 */
public class UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
			return 1;
		int x = obstacleGrid.length, y = obstacleGrid[0].length;
		int[][] a = new int[x][y];
		a[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (obstacleGrid[i][j] == 1) {
					a[i][j] = 0;
				} else if (i == 0) {
					if (j == 0)
						continue;
					a[i][j] = a[i][j - 1];
				} else if (j == 0) {
					a[i][j] = a[i - 1][j];
				} else {
					a[i][j] = a[i][j - 1] + a[i - 1][j];
				}
			}
		}
		return a[x - 1][y - 1];

	}

	public static void main(String args[]) {
		new UniquePathsII().uniquePathsWithObstacles(new int[][] {});
	}
}
