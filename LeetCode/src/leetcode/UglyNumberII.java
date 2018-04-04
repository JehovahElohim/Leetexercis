package leetcode;

import java.util.Arrays;

public class UglyNumberII {
	public int nthUglyNumber(int n) {
		if (n <= 0)
			return 0;
		if (n == 1)
			return 1;
		int dp[] = new int[n];
		dp[0] = 1;
		int p2 = 0;
		int p3 = 0;
		int p5 = 0;

		long res2 = dp[p2] * 2;
		long res3 = dp[p3] * 3;
		long res5 = dp[p5] * 5;

		for (int i = 1; i < dp.length; i++) {
			if (res2 <= res3 && res2 <= res5) {
				dp[i] = (int) res2;
				res2 = dp[++p2] * 2;
			} else if (res3 <= res2 && res3 <= res5) {
				dp[i] = (int) res3;
				res3 = dp[++p3] * 3;
			} else if (res5 <= res3 && res5 <= res2) {
				dp[i] = (int) res5;
				res5 = dp[++p5] * 5;
			}
			if (dp[i - 1] == dp[i]) {
				i--;
			}
		}

		return dp[dp.length - 1];
	}
}
