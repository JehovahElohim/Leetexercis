package leetcode;

import java.util.Arrays;

public class IntegerBreak {
	public int integerBreak(int n) {
		int dp[] = new int[n];
		dp[0] = 1;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < (i + 1) / 2; j++) {
				dp[i] = Math
						.max(dp[i],
								Math.max(dp[j], j + 1)
										* Math.max(dp[i - j - 1], i - j));
			}
		}
		System.out.println(Arrays.toString(dp));
		return dp[n - 1];
	}
}
