package leetcode;

import java.util.Arrays;

public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		if ((s == null && p == null))
			return true;
		if (s == null || p == null)
			return false;

		boolean dp[][] = new boolean[p.length() + 1][s.length() + 1];
		dp[0][0] = true;
		for (int i = 1; i < dp.length; i++) {
			if (p.charAt(i - 1) == '*') {
				dp[i][0] = dp[i - 2][0];
			}
		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (s.charAt(j - 1) == p.charAt(i - 1) && dp[i - 1][j - 1])
					dp[i][j] = true;
				else if (p.charAt(i - 1) == '.' && dp[i - 1][j - 1])
					dp[i][j] = true;
				else if (p.charAt(i - 1) == '*') {
					if (((p.charAt(i - 2) == s.charAt(j - 1) || p.charAt(i - 2) == '.') && dp[i][j - 1])
							|| dp[i - 2][j])
						dp[i][j] = true;
				}
			}
		}
		return dp[dp.length - 1][dp[0].length - 1];
	}

	public static void main(String args[]) {
		RegularExpressionMatching s = new RegularExpressionMatching();
		System.out.println(s.isMatch("aaa", "aa*"));
	}
}
