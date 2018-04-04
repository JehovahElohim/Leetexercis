package leetcode;

import java.util.Arrays;

public class PalindromePartitioningII {
	public static int minCut(String s) {
		if (s == null || s.length() == 1)
			return 0;

		// isPalindrome[i][j]表示从s的从i到j是否为回文（前闭后闭）
		boolean[][] isPalindrome = new boolean[s.length()][s.length()];
		// dp表示0-i需要切割的最小次数
		// 当每次加入一个新的字符时，需要判断包含此字符的最大回文子串。
		int[] dp = new int[s.length()];

		for (int i = 0; i < dp.length; i++) {
			isPalindrome[i][i] = true;
		}
		for (int i = 0; i < dp.length - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1))
				isPalindrome[i][i + 1] = true;
		}

		for (int i = 2; i < dp.length; i++) {
			for (int j = 0; j < dp.length - i; j++) {
				if (isPalindrome[j + 1][i + j - 1]
						&& s.charAt(j) == s.charAt(j + i))
					isPalindrome[j][j + i] = true;
			}
		}
		for (int i = 0; i < dp.length; i++) {
			System.out.println(Arrays.toString(isPalindrome[i]));
		}
		dp[0] = 0;
		for (int i = 1; i < dp.length; i++) {
			int min = Integer.MAX_VALUE;
			// 加入新字符时，找到以包含该字符的回文子串的最小分割值
			for (int j = 0; j < i; j++) {
				if (isPalindrome[j][i]) {
					if (j == 0)
						min = 0;
					else
						min = Math.min(min, dp[j - 1] + 1);
				}
			}
			dp[i] = Math.min(dp[i - 1] + 1, min);
		}
		System.out.println(Arrays.toString(dp));
		return dp[s.length() - 1];
	}

	public static void main(String args[]) {
		System.out.println(minCut("abccba"));
	}
}
