package leetcode;

public class ClimbingStairs {
	public int climbStairs(int n) {
		if (n < 1)
			return 0;
		if (n == 1)
			return 1;
		int[] dp = new int[n];
		dp[0] = 1;
		dp[1] = 2;
		for (int i = 2; i < dp.length; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[dp.length - 1];
	}
}
