package leetcode;

import java.util.Arrays;

public class CoinChange {
	public static int coinChange(int[] coins, int amount) {
		if (amount < 0 || coins == null || coins.length == 0) {
			return -1;
		}
		int dp[][] = new int[coins.length][amount + 1];
		Arrays.sort(coins);
		System.out.println(Arrays.toString(coins));
		for (int i = 1; i < dp[0].length; i++) {
			dp[0][i] = i % coins[0] == 0 ? i / coins[0] : -1;
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j <= amount; j++) {
				if (j - coins[i] < 0 || dp[i][j - coins[i]] == -1) {
					dp[i][j] = dp[i - 1][j];
				} else {
					if (dp[i - 1][j] != -1)
						dp[i][j] = Math.min(dp[i][j - coins[i]] + 1,
								dp[i - 1][j]);
					else
						dp[i][j] = dp[i][j - coins[i]] + 1;
				}
			}
		}
		for (int i = 0; i < dp.length; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
		System.out.println(dp[3][2800 - 419]);
		return dp[coins.length - 1][amount];
	}

	public static void main(String args[]) {
		System.out.println(coinChange(new int[] { 186, 419, 83, 408 }, 2381));
	}
}
