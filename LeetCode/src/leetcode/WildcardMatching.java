package leetcode;

import java.util.LinkedList;
import java.util.List;

public class WildcardMatching {

	public static boolean isMatch(String s, String p) {
		boolean res[] = new boolean[1];

		dfs(s, handle(p), 0, 0, res);
//		System.out.println(res[0]);
		return res[0];
	}

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

	public static void main(String args[]) {
		System.out.println(getCountBehindStar("*a*b***", 0));
		isMatch("aab", "*a*b***");

	}
}
