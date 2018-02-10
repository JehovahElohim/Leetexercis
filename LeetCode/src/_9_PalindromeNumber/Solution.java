package _9_PalindromeNumber;

public class Solution {
	public boolean isPalindrome(int x) {
		if (x >= 0) {
			int len = (x + "").length();
			for (int i = 0; i < len / 2; i++) {
				int f = (int) Math.pow(10, len - i * 2 - 1);
				int l = (x / f);
				if (l != x % 10)
					return false;
				x = (int) ((x - f * l) / 10);
			}
		} else
			return false;
		return true;
	}

	public static void main(String args[]) {
		System.out.println(new Solution().isPalindrome(1223221));
	}
}
