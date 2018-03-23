package leetcode;

/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * For example, "A man, a plan, a canal: Panama" is a palindrome. "race a car"
 * is not a palindrome.
 * 
 * author asus pca
 *
 */
public class ValidPalindrome {
	public static boolean isPalindrome(String s) {
		StringBuilder sb = new StringBuilder();
		s = s.toLowerCase();
		for (int i = 0; i < s.length(); i++) {
			if (Character.isAlphabetic(s.charAt(i))
					|| (s.charAt(i) >= '0' && s.charAt(i) <= '9'))
				sb.append(s.charAt(i));
		}
		int n = sb.length() / 2;
//		System.out.println(sb);
		for (int i = 0; i < n; i++) {
			if (sb.charAt(i) != sb.charAt(sb.length() - i - 1))
				return false;
		}
		return true;
	}

	public static void main(String args[]) {
		System.out.println(isPalindrome("ab@a"));
	}
}
