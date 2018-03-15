package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number
 * could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below.
 * 
 * 
 * 
 * Input:Digit string "23" Output: ["ad", "ae", "af", "bd", "be", "bf", "cd",
 * "ce", "cf"].
 * 
 * @author asus pc
 *
 */
public class LetterCombinationsofaPhoneNumber {
	public List<String> letterCombinations(String digits) {
		List<String> res = new LinkedList<String>();
		if (digits == null)
			return res;
		String[] letters = { " ", "", "abc", "def", "ghi", "jkl", "mno",
				"pqrs", "tuv", "wxyz" };
		StringBuilder sb = new StringBuilder();
		dfs(sb, letters,  -1, digits, res);
		return res;
	}
	//depth 第N个数字
	//num 第n个数字的第m个字母
	private void dfs(StringBuilder singleRes, String[] letters,
			int depth, String digits, List<String> res) {
		depth++;
		if (depth >= digits.length())
			return;
		int ch = digits.charAt(depth)-48;
		for (int i = 0; i < letters[ch].length(); i++) {
			singleRes.append(letters[ch].charAt(i));
			if (singleRes.length() == digits.length())
				res.add(singleRes.toString());
			dfs(singleRes, letters, depth, digits, res);
			singleRes.deleteCharAt(singleRes.length() - 1);
		}
		depth--;
	}

	public static void main(String args[]) {
		List<String> list = new LetterCombinationsofaPhoneNumber()
				.letterCombinations("23");
		for (String object : list) {
			System.out.print(object + " ");
		}
	}
}
