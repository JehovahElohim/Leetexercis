package leetcode;

import java.util.LinkedList;
import java.util.List;

public class WildcardMatching {

	public static boolean isMatch(String s, String p) {
		boolean res[] = new boolean[1];

		dfs(s, handle(p), 0, 0, res);
		// System.out.println(res[0]);
		return res[0];
	}

	// 消除重复*
	public static String handle(String p) {
		int len = p.length();
		if (len == 0)
			return p;
		StringBuilder sb = new StringBuilder();
		int i;
		for (i = 0; i < len - 1; i++) {
			if (p.charAt(i) == '*' && p.charAt(i + 1) == '*')
				continue;
			sb.append(p.charAt(i));
		}
		sb.append(p.charAt(i));
		return sb.toString();
	}

	public static int getCountBehindStar(String p, int pIndex) {
		int count = 0;
		int len = p.length();
		for (int i = pIndex + 1; i < len; i++) {
			if (p.charAt(i) != '*')
				count++;
		}
		return count;
	}

	// 暴力递归dfs回溯 ：主要回溯“*”
	public static void dfs(String s, String p, int sIndex, int pIndex,
			boolean[] res) {
		int sLen = s.length();
		int pLen = p.length();
		if (res[0])
			return;
		if (sLen == sIndex && pLen == pIndex) {
			res[0] = true;
			return;
		} else if (sLen <= sIndex && p.charAt(pIndex) == '*') {
			dfs(s, p, sIndex, pIndex + 1, res);
		} else if (sLen <= sIndex || pLen <= pIndex)
			return;
		if (sIndex < sLen && s.charAt(sIndex) == p.charAt(pIndex))
			dfs(s, p, sIndex + 1, pIndex + 1, res);
		else if (p.charAt(pIndex) == '?')
			dfs(s, p, sIndex + 1, pIndex + 1, res);
		else if (p.charAt(pIndex) == '*') {
			int n = sLen - sIndex - getCountBehindStar(p, pIndex);
			for (int i = 0; i <= n; i++) {
				dfs(s, p, sIndex + i, pIndex + 1, res);
			}
		}
	}

	// dp
	public static boolean dp(String s, String p) {
		// p = handle(p);
		int len1 = s.length();
		int len2 = p.length();
		boolean dp[][] = new boolean[len1 + 1][len2 + 1];
		dp[0][0] = true;
		boolean letter = true;
		for (int i = 1; i < dp[0].length; i++) {
			if (letter) {
				dp[0][i] = p.charAt(i - 1) == '*';
			}
			if (p.charAt(i - 1) != '*') {
				letter = false;
			}
		}
		for (int i = 1; i < dp.length; i++) {
			dp[i][0] = s.charAt(i - 1) == '*';
		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (p.charAt(j - 1) != '*') {
					if (p.charAt(j - 1) == '?') {
						dp[i][j] = dp[i - 1][j - 1];
					} else {
						dp[i][j] = dp[i - 1][j - 1]
								&& s.charAt(i - 1) == p.charAt(j - 1);
					}
				} else {
					dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
				}
			}
		}
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		return dp[len1][len2];
	}

	public static void main(String args[]) {
		System.out.println(dp("ab", "**ab"));

	}
}
