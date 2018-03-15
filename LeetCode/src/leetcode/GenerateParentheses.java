package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * @author asus pc
 *
 */
public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<String>();
		dfs("", 0, 0, n, res);
		return res;
	}

	void dfs(String s, int L, int R, int n, List<String> res) {
		if (R == n) {
			System.out.println(s);
			res.add(s);
		} else {
			if (L == n) {
				dfs(s + ")", L, R + 1, n, res);
			} else if (L > R) {
				dfs(s + ")", L, R + 1, n, res);
				dfs(s + "(", L + 1, R, n, res);
			} else if (L == R) {
				dfs(s + "(", L + 1, R, n, res);
			}
		}

	}

	public static void main(String arsg[]) {
		new GenerateParentheses().generateParenthesis(3);
	}
}
