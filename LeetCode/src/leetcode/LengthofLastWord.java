package leetcode;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space
 * characters only.
 * 
 * Example:
 * 
 * Input: "Hello World" Output: 5
 * 
 * @author asus pc
 *
 */
public class LengthofLastWord {
	public int lengthOfLastWord(String s) {
		int len = s.length();
		int end = len - 1;
		for (int i = len - 1; i >= 0; i--) {
			if (s.charAt(i) == ' ') {
				end--;
			} else {
				break;
			}
		}
		if (end == -1)
			return 0;
		int start = end;
		while (start != 0 && s.charAt(start) != ' ') {
			start--;
		}
		if (start == 0 && s.charAt(0) != ' ')
			return end + 1;
		return end - start;
	}

	public static void main(String args[]) {
		System.out.println(new LengthofLastWord().lengthOfLastWord("a "));
	}
}
