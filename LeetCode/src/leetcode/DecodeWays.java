package leetcode;

import java.util.Arrays;

public class DecodeWays {
	public static int numDecodings(String s) {
		return dfs(s, 0);
	}

	// DP
	public static int dp(String s) {
		if (s.length() <= 0)
			return 0;
		int[] dp = new int[s.length()];
		if (s.length() == 1) {
			return check(s) ? 1 : 0;
		}
		dp[0] = check(s.substring(0, 1)) ? 1 : 0;
		dp[1] = (check(s.substring(0, 2)) ? 1 : 0)
				+ (check(s.substring(1, 2)) ? dp[0] : 0);
		for (int i = 2; i < dp.length; i++) {
			dp[i] = (check(s.substring(i - 1, i + 1)) ? dp[i - 2] : 0)
					+ (check(s.substring(i, i + 1)) ? dp[i - 1] : 0);
		}
		System.out.println(Arrays.toString(dp));
		return dp[s.length() - 1];
	}

	public static boolean check(String sub) {
		if (sub.length() == 1 && Integer.valueOf(sub) != 0)
			return true;
		else if (sub.length() == 2 && sub.charAt(0) != '0'
				&& Integer.valueOf(sub) < 27)
			return true;
		return false;
	}

	// 递归
	public static int dfs(String s, int index) {
		if (index < 0 || index > s.length())
			return 0;
		else if (index == s.length())
			return 1;
		String s1 = s.substring(index, index + 1);
		int sum = 0;
		if (Integer.valueOf(s1) != 0)
			sum += dfs(s, index + 1);
		if (index + 2 > s.length())
			return sum;
		String s2 = s.substring(index, index + 2);
		if (s2.charAt(0) != '0' && Integer.valueOf(s2) < 27)
			sum += dfs(s, index + 2);
		return sum;
	}

	public static void main(String args[]) {
		System.out.println(numDecodings("01"));
		System.out.println(dp("01"));
	}
}
