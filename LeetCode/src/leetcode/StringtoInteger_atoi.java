package leetcode;

public class StringtoInteger_atoi {
	public int myAtoi(String str) {
		if (str == null||str.equals(""))
			return 0;
		boolean negative = false;
		int p = 0;
		str = str.trim();
		if (str.charAt(0) < '0') {
			if (str.charAt(0) == '-') {
				negative = true;
				p++;
			} else {
				if (str.charAt(0) != '+')
					return 0;
				else
					p++;
			}
		}
		long result = 0;
		while (p < str.length()) {
			if (Character.isDigit(str.charAt(p))) {
				result = (str.charAt(p) - 48) + result * 10;
				if (result > Integer.MAX_VALUE && !negative)
					return Integer.MAX_VALUE;
				else if (result > (long) Integer.MAX_VALUE + 1 && negative) {
					System.out.println(Integer.MAX_VALUE + 1);
					return Integer.MIN_VALUE;
				}
			} else
				return (int) (negative ? -result : result);
			p++;
		}
		return (int) (negative ? -result : result);

	}

	public static void main(String args[]) {
		StringtoInteger_atoi s = new StringtoInteger_atoi();
		System.out.println(s.myAtoi(""));
	}
}
