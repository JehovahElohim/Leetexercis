package leetcode;

public class ImplementstrStr {
	public int strStr(String haystack, String needle) {
		if (haystack == null || needle == null)
			return -1;

		int len1 = haystack.length();
		int len2 = needle.length();
		if (len2 - len1 > 0)
			return -1;

		if (needle.equals(""))
			return 0;

		for (int i = 0; i <= len1 - len2; i++) {
			if (haystack.charAt(i) == needle.charAt(0)) {
				int j = 0;
				for (; j < len2; j++) {
					if (haystack.charAt(i + j) != needle.charAt(j))
						break;
				}
				if (j == len2)
					return i;
			}
		}
		return -1;
	}

	public static void main(String arsg[]) {
		System.out
				.println(new ImplementstrStr().strStr("mississippi", "issip"));
	}
}
