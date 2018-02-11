package leetcode;

/**
 * Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3. 
 
 Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
	public static int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0)
			return 0;
		HashSet<Character> set = new HashSet<Character>();
		int length = s.length();
		int max = 0;
		int left = 0;
		int right = 0;
		while (right < length) {
			if (!set.contains(s.charAt(right))) {
				set.add(s.charAt(right));
				right++;
			} else {
				max = Math.max(right - left, max);
				set.remove(s.charAt(left));
				left++;
			}
		}
		return Math.max(right - left, max);
	}

	public static void main(String args[]) {
		// Character a = '1';
		// char b = '1';
		// System.out.println(a == b);
		String a = "aqweqweab";
		System.out.println(lengthOfLongestSubstring(a));
	}
}
