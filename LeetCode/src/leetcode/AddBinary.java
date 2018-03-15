package leetcode;

public class AddBinary {
	public String addBinary(String a, String b) {
		StringBuilder res = new StringBuilder();
		if (a.equals("")) {
			if (b.equals(""))
				return "";
			else {
				return b;
			}
		}
		if (b.equals(""))
			return a;

		int len = 0;
		if (a.length() != b.length()) {
			StringBuilder zeros = new StringBuilder();
			int count = Math.abs(b.length() - a.length());
			for (int i = 0; i < count; i++) {
				zeros.append("0");
			}
			if (a.length() < b.length())
				a = zeros.toString() + a;
			else {
				b = zeros.toString() + b;
			}

		}
		len = a.length();

		char[] chs = new char[len];
		int carry = 0;
		for (int i = len - 1; i >= 0; i--) {
			if (carry == 1) {
				if (a.charAt(i) == '1' && b.charAt(i) == '1') {
					chs[i] = '1';
				} else if (a.charAt(i) == '1' || b.charAt(i) == '1') {
					chs[i] = '0';
				} else {
					chs[i] = '1';
					carry = 0;
				}
			} else {
				if (a.charAt(i) == '1' && b.charAt(i) == '1') {
					chs[i] = '0';
					carry = 1;
				} else if (a.charAt(i) == '1' || b.charAt(i) == '1') {
					chs[i] = '1';
				} else {
					chs[i] = '0';
				}
			}
		}
		if (carry == 1)
			return "1" + String.valueOf(chs);
		return String.valueOf(chs);
	}

	public static void main(String args[]) {
		System.out.println(new AddBinary().addBinary("1", "11"));
	}
}
