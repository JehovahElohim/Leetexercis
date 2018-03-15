package leetcode;

/**
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 * 
 * @author asus pc
 *
 */
public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		else if (strs.length == 1)
			return strs[0];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < strs[0].length(); i++) {
			char ch = strs[0].charAt(i);
			for (String string : strs) {
				if (string.length() <= i || string.charAt(i) != ch) {
					return sb.toString();
				}
			}
			sb.append(ch);
		}
		return sb.toString();
	}

	public static void main(String args[]) {
		System.out.println(new LongestCommonPrefix()
				.longestCommonPrefix(new String[] { "", "23" }));
	}
}
