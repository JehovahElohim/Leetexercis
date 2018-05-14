package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	public List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<List<String>>();
		if (s == null || s.length() == 0)
			return res;
		// isPalindrome[i][j]表示从s的从i到j是否为回文（前闭后闭）
		boolean[][] isPalindrome = new boolean[s.length()][s.length()];
		// dp表示0-i需要切割的最小次数
		// 当每次加入一个新的字符时，需要判断包含此字符的最大回文子串。
		for (int i = 0; i < isPalindrome.length; i++) {
			isPalindrome[i][i] = true;
		}
		for (int i = 0; i < isPalindrome.length - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1))
				isPalindrome[i][i + 1] = true;
		}

		for (int i = 2; i < isPalindrome.length; i++) {
			for (int j = 0; j < isPalindrome.length - i; j++) {
				if (isPalindrome[j + 1][i + j - 1]
						&& s.charAt(j) == s.charAt(j + i))
					isPalindrome[j][j + i] = true;
			}
		}
		List<String> temp = new ArrayList<String>();
		dfs(s, res, temp, 0, isPalindrome);
		return res;
	}

	public static void dfs(String s, List<List<String>> res, List<String> temp,
			int index, boolean[][] is) {
		if (index >= s.length()) {
			res.add(new ArrayList<String>(temp));
			return;
		}
		for (int i = index; i < s.length(); i++) {
			if (is[index][i]) {
				temp.add(s.substring(index, i + 1));
				dfs(s, res, temp, i + 1, is);
				temp.remove(temp.size() - 1);
			}
		}
	}	
}
