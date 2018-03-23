package leetcode;

/**
 * Given a string S and a string T, count the number of distinct subsequences of
 * S which equals T.
 * 
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ACE" is a
 * subsequence of "ABCDE" while "AEC" is not).
 * 
 * Here is an example: S = "rabbbit", T = "rabbit"
 * 
 * Return 3.
 * 
 * @author asus pc
 *
 */
public class DistinctSubsequences {
	/*
	 * 动态规划，定义dp[i][j]为字符串i变换到j的变换方法。 如果S[i]==T[j]，那么dp[i][j] = dp[i-1][j-1] +
	 * dp[i-1][j]。意思是：如果当前S[i]==T[j]，那么当前这个字母即可以保留也可以抛弃，
	 * 所以变换方法等于保留这个字母的变换方法加上不用这个字母的变换方法。 如果S[i]!=T[i]，那么dp[i][j] =
	 * dp[i-1][j]，意思是如果当前字符不等，那么就只能抛弃当前这个字符。
	 */
	public static int numDistinct(String s, String t) {
		
		int dp[][] = new int[s.length() + 1][t.length() + 1];
		dp[0][0] = 1;
		for (int i = 1; i < dp[0].length; i++) {
			dp[0][i] = 0;
		}
		for (int i = 1; i < dp.length; i++) {
			dp[i][0] = 1;
		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
				else
					dp[i][j] = dp[i - 1][j];
			}
		}
		return dp[s.length()][t.length()];
	}

	// 暴力递归
	public static int dfs(String s, String t) {
		int len1 = s.length();
		int len2 = t.length();
		if (len2 == 0)
			return 1;
		if (len1 < len2)
			return 0;
		if (!contains(s, t))
			return 0;
		int n = len1 - len2;
		int sum = 0;
		for (int i = 0; i <= n; i++) {
			if (s.charAt(i) == t.charAt(0))
				sum += dfs(s.substring(i + 1), t.substring(1));
		}
		return sum;
	}

	public static boolean contains(String s, String t) {
		int letters[] = new int[256];
		for (int i = 0; i < s.length(); i++) {
			letters[s.charAt(i)]++;
		}
		for (int i = 0; i < t.length(); i++) {
			letters[t.charAt(i)]--;
		}
		for (int i = 0; i < 256; i++) {
			if (letters[i] < 0)
				return false;
		}
		return true;
	}

	public static void main(String args[]) {
		System.out.println(numDistinct("CBAZTAAABBCTA", "CAT"));
	}
}
