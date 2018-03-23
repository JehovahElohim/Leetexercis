package leetcode;

import java.util.Arrays;

public class ShortestPalindrome {
	// KMP求解最长前缀后缀，先处理字符串，s = s+#+反转s
	public static String next(String s) {
		StringBuilder sb = new StringBuilder(s);
		sb.reverse();
		StringBuilder sa = new StringBuilder();
		sa.append(s).append("#").append(sb);
		int next[] = new int[sa.length()];
		int j = 0;
		int k = -1;
		next[0] = -1;
		while (j < next.length - 1) {
			if (k == -1 || sa.charAt(k) == sa.charAt(j)) {
				next[++j] = ++k;
			} else {
				k = next[k];
			}
		}
		StringBuilder sb1 = new StringBuilder();
		sb1.append(s.substring(next[next.length - 1] + 1));
		sb1.reverse().append(s);
		System.out.println(sb1);
		return sb1.toString();
	}

	// 暴力求解 ，求包含s[0]的最长回文串
	public static String shortestPalindrome(String s) {
		int p = s.length();
		int i = 0;
		int n = p / 2;
		while (i <= n) {
			int j = 0;
			for (j = 0; j < n; j++) {
				if (s.charAt(j) != s.charAt(p - j - 1))
					break;
			}
			if (j == n)
				break;

			p--;
			n = p / 2;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(s.substring(p));
		sb.reverse().append(s);
		return sb.toString();
	}

	public static void main(String args[]) {
		next("acada");
		// shortestPalindrome("daca");
	}
}
