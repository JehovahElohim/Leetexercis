package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InterleavingString {
	// 暴力递归
	public static boolean isInterleave(String s1, String s2, String s3) {
		int len1 = s1.length();
		int len2 = s2.length();
		int len3 = s3.length();
		if (len1 + len2 != len3)
			return false;

		Set<String> res = new HashSet<String>();
		List<Integer> temp = new ArrayList<Integer>();

		dfs(res, temp, s1, s3, 0, 0);

		for (String s : res) {
			if (s2.equals(s))
				return true;
		}

		return false;
	}

	public static void dfs(Set<String> res, List<Integer> temp, String s1,
			String s3, int s1Start, int s3Start) {
		int len1 = s1.length();
		int len3 = s3.length();
		if (len1 > len3 || len3 < s3Start)
			return;
		if (len1 == temp.size()) {
			StringBuilder sb = new StringBuilder();
			int p = 0;
			for (int i = 0; i < len3; i++) {
				System.out.println(p);
				if (p >= len1 || temp.get(p) != i)
					sb.append(s3.charAt(i));
				else {
					p++;
				}
			}
			res.add(sb.toString());
			System.out.println(sb.toString());
			return;
		}

		for (int i = s3Start; i < len3; i++) {
			if (s1.charAt(s1Start) == s3.charAt(i)) {
				temp.add(i);
				dfs(res, temp, s1, s3, 1 + s1Start, i + 1);
				temp.remove(temp.size() - 1);
			}
		}
	}

	// dp dp[i][j] 表示 s2 的前 i 个字符和 s1 的前 j 个字符是否匹配 s3 的前 i+j 个字符。
	public static boolean isInterleave1(String s1, String s2, String s3) {
		int len1 = s1.length();
		int len2 = s2.length();
		
		if (len1 + len2 != s3.length())
			return false;
		boolean dp[][] = new boolean[len1 + 1][len2 + 1];
		dp[0][0] = true;
		for (int i = 1; i < dp[0].length; i++) {
			dp[0][i] = dp[0][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1);
		}
		for (int i = 1; i < dp.length; i++) {
			dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				dp[i][j] = (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j
						- 1))
						|| (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j
								- 1));
			}
		}
		return dp[len1][len2];
	}

	public static void main(String arsgs[]) {
		System.out.println(isInterleave1("aabcc", "dbbca", "aadbbbaccc"));
	}
}
