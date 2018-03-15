package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * You are given a string, s, and a list of words, words, that are all of the
 * same length. Find all starting indices of substring(s) in s that is a
 * concatenation of each word in words exactly once and without any intervening
 * characters.
 * 
 * For example, given: s: "barfoothefoobarman" words: ["foo", "bar"]
 * 
 * You should return the indices: [0,9]. (order does not matter).
 * 
 * @author asus pc
 *
 */

public class SubstringwithConcatenationofAllWords {
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new ArrayList<Integer>();
		if (s == null || words == null || words.length == 0)
			return res;

		int len = s.length();
		int lenSub = words[0].length();
		int wordsLen = lenSub * words.length;

		Map<String, Integer> wordsRecord = new HashMap<>();
		for (String string : words) {
			if (!wordsRecord.containsKey(string))
				wordsRecord.put(string, 1);
			else
				wordsRecord.put(string, wordsRecord.get(string) + 1);
		}
		for (int i = 0; i < lenSub; i++) {
			int L = i, R = i;
			while (R <= len) {
				R += lenSub;
				if (R <= len && !isWord(s, R - lenSub, R, words)) {
					L = R;
				}
				if (R - L == wordsLen) {
					if (isValid(s, L, lenSub, words.length, words, wordsRecord)) {
						res.add(L);
					}
					L += lenSub;
				}
			}
		}
		System.out.println("res;");
		for (Integer integer : res) {
			System.out.print(integer + " ");
		}
		return res;
	}

	private boolean isWord(String s, int l, int r, String[] words) {
		String s1 = s.substring(l, r);
		System.out.println(s1 + " -");
		for (String string : words) {
			if (s1.equals(string))
				return true;
		}
		return false;
	}

	private boolean isValid(String s, int l, int subLen, int n, String[] words,
			Map<String, Integer> wordsRecord) {
		if (l + subLen * n > s.length())
			return false;

		Map<String, Integer> map = new HashMap<>();
		for (String string : wordsRecord.keySet()) {
			map.put(new String(string), wordsRecord.get(string));
		}
		for (int i = 0; i < words.length; i++) {
			String word = s.substring(l + subLen * i, l + subLen * (i + 1));
			System.out.println(word + " I");
			if (map.get(word) == 0)
				return false;
			map.put(word, map.get(word) - 1);
		}
		return true;
	}

	public static void main(String[] args) {
		new SubstringwithConcatenationofAllWords().findSubstring(
				"lingmindraboofooowingdingbarrwingmonkeypoundcake",
				new String[] { "fooo", "barr", "wing", "ding", "wing" });
	}

}
