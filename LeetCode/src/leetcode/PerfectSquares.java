package leetcode;

import java.util.Arrays;

public class PerfectSquares {
	public static int numSquares(int n) {
		int dp[] = new int[n];

		int m = 1;
		while (m <= n / m) {
			dp[m * m - 1] = 1;
			m++;
		}
		System.out.println(Arrays.toString(dp));
		for (int i = 1; i < dp.length; i++) {
			if (dp[i] == 0) {
				int min = Integer.MAX_VALUE;
				for (int j = 1; j * j < i + 1; j++) {
					min = Math.min(min, dp[i - j * j] + 1);
				}
				dp[i] = min;
			}
		}
		System.out.println(Arrays.toString(dp));
		return dp[n - 1];
	}
	public static void main(String args[]){
		numSquares(5);
	}
}
