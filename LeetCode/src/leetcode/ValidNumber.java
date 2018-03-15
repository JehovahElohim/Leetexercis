package leetcode;

public class ValidNumber {
	public boolean isNumber(String s) {
		s = s.trim();
		int len = s.length();
		try {
			Double.valueOf(s);
		} catch (NumberFormatException e) {
			return false;
		}
		if (s.charAt(len - 1) < '0' || s.charAt(len - 1) > '9') {
			if (s.charAt(len - 1) != '.') {
				System.out.println(123123);
				return false;
			}
		}
		System.out.println(33);
		return true;
	}

	public static void main(String arsg[]) {
		new ValidNumber().isNumber("3.");
	}
}
