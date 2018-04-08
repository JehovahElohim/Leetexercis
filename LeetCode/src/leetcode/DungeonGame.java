package leetcode;

import java.util.Arrays;

public class DungeonGame {
	//
	public static int calculateMinimumHP_wrong(int[][] dungeon) {

		/*
		 * 很明显用DP，但是如何用DP，刚开始的想法是，
		 * 
		 * 1、用两个数组，一个数组记录到当前位置需要的最小血量min[len]，另一个是在最小血量的情况下路径上的数的和sum[len]。
		 * 
		 * 2、第一行因为只能一直向右走，所以很简单。
		 * 
		 * 3、从第二行开始，有两种选项，从上面来还是从左边来（第一个单独算），然后比较这两种选项需要的最小血量，选择较小的那条路。
		 * 
		 * 4、在两种选项的血量一样的时候，选择sum较大的走。
		 * 
		 * 但是这样会出错。
		 * 
		 * [[1,-3,3],[0,-2,0],[-3,-3,-3]]这一组就会出错，因此这样是不对的。局部最优不等于全局最优。
		 */
		// 到[i][j]时所需的最小生命
		int least[][] = new int[dungeon.length][dungeon[0].length];
		// 到[i][j]时所需的最小生命时的最大生命值
		int h[][] = new int[dungeon.length][dungeon[0].length];

		h[0][0] = Math.max(1, dungeon[0][0] + 1);
		least[0][0] = (dungeon[0][0] < 0 ? -dungeon[0][0] : 0) + 1;

		for (int i = 1; i < h[0].length; i++) {
			if (dungeon[0][i] < 0 && h[0][i - 1] + dungeon[0][i] <= 0) {
				least[0][i] = Math.abs(h[0][i - 1] + dungeon[0][i])
						+ least[0][i - 1] + 1;
				h[0][i] = 1;
			} else {
				least[0][i] = least[0][i - 1];
				h[0][i] = h[0][i - 1] + dungeon[0][i];
			}
		}

		for (int i = 1; i < h.length; i++) {
			if (dungeon[i][0] < 0 && h[i - 1][0] + dungeon[i][0] <= 0) {
				least[i][0] = Math.abs(h[i - 1][0] + dungeon[i][0])
						+ least[i - 1][0] + 1;
				h[i][0] = 1;
			} else {
				least[i][0] = least[i - 1][0];
				h[i][0] = h[i - 1][0] + dungeon[i][0];
			}
		}

		for (int i = 1; i < h.length; i++) {
			for (int j = 1; j < h[0].length; j++) {
				int m1, m2;
				int h1, h2;
				if (dungeon[i][j] < 0 && h[i - 1][j] + dungeon[i][j] <= 0) {
					m1 = Math.abs(h[i - 1][j] + dungeon[i][j])
							+ least[i - 1][j] + 1;
					h1 = 1;
				} else {
					m1 = least[i - 1][j];
					h1 = h[i - 1][j] + dungeon[i][j];
				}
				if (dungeon[i][j] < 0 && h[i][j - 1] + dungeon[i][j] <= 0) {
					m2 = Math.abs(h[i][j - 1] + dungeon[i][j])
							+ least[i][j - 1] + 1;
					h2 = 1;
				} else {
					m2 = least[i][j - 1];
					h2 = h[i][j - 1] + dungeon[i][j];
				}
				// m1更小就采用h[i][j]上侧走法的 生命
				if (m1 < m2) {
					least[i][j] = m1;
					h[i][j] = h1;
				} else if (m2 < m1) {
					least[i][j] = m2;
					h[i][j] = h2;
				} else {
					least[i][j] = m1;
					h[i][j] = Math.max(h1, h2);
				}
				if (i == h.length - 1 && j == h[0].length - 1)
					System.out.println(m1 + "  " + m2);
			}
		}
		for (int i = 0; i < h.length; i++) {
			for (int j = 0; j < h[0].length; j++) {
				System.out.print(least[i][j] + "/" + h[i][j] + " ");
			}
			System.out.println();
		}
		return least[dungeon.length - 1][dungeon[0].length - 1];
	}

	/*
	 * 反过来，从结尾开始，表示当前位置到结尾最少需要的血量
	 */
	/*
	 * 总结： 按照第一种解法
	 * 它的dp[i][j]的解应该包含4个方向，但是只考虑了下和右，因为不是每个格子只能走一次，没有考虑到可以走其他格子加血的情况。
	 * 
	 * 第二种解法因为是从左上角加入，所以只能包含下和右，处理了无后效性。
	 */
	public static int calculateMinimumHP(int[][] dungeon) {
		int m = dungeon.length - 1;
		int n = dungeon[0].length - 1;

		int dp[][] = new int[m + 1][n + 1];
		dp[m][n] = dungeon[m][n] < 0 ? (-dungeon[m][n]) + 1 : 1;

		for (int i = m - 1; i >= 0; i--) {
			dp[i][n] = Math.max(dp[i + 1][n] - dungeon[i][n], 1);
		}
		for (int i = n - 1; i >= 0; i--) {
			dp[m][i] = Math.max(dp[m][i + 1] - dungeon[m][i], 1);
		}
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				dp[i][j] = Math.min(Math.max(dp[i][j + 1] - dungeon[i][j], 1),
						Math.max(dp[i + 1][j] - dungeon[i][j], 1));
			}
		}
		return dp[0][0];
	}

	public static void main(String args[]) {
		int a[][] = { { 1, -3, 3 }, { 0, -2, 0 }, { -3, -3, -3 } };
		int b[][] = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
		// calculateMinimumHP_wrong(a);
		calculateMinimumHP(a);
	}
}
