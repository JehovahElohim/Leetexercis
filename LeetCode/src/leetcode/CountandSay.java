package leetcode;

public class CountandSay {
	public String countAndSay(int n) {
		if (n <= 1) {
			return "1";
		}
		StringBuilder res = new StringBuilder();
		String s = "1";
		for (int i = 0; i < n - 1; i++) {
			int len = s.length();
			int count = 1;
			int j = 0;
			for (j = 0; j < len - 1; j++) {
				if (s.charAt(j) == s.charAt(j + 1)) {
					count++;
				} else {
					res.append(count);
					res.append(s.charAt(j));
					count = 1;
				}
			}
			res.append(count);
			res.append(s.charAt(j));
			s = res.toString();
			res = new StringBuilder();
		}
		return s;
	}

	public static void main(String[] args) {
		new CountandSay().countAndSay(7);
	}

}
