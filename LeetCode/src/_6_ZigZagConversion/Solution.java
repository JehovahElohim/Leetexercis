package _6_ZigZagConversion;

public class Solution {
	public String convert(String s, int numRows) {
		if (numRows == 1)
			return s;
		StringBuilder sb = new StringBuilder();
		int ss = (numRows - 1) * 2;
		for (int i = 0; i < numRows; i++) {
			if (i < s.length())
				sb.append(s.charAt(i));
			int sum = ss;
			while (true) {
				if (i != 0 && i != numRows - 1) {
					if (sum - i < s.length())
						sb.append(s.charAt(sum - i));
					else
						break;
				}
				if (sum + i < s.length()) {
					sb.append(s.charAt(sum + i));
					sum = sum + ss; 
				} else
					break;
			}
		}
		return sb.toString();

	}

	public static void main(String args[]) {
		Solution s = new Solution();
		System.out.println(s.convert("123456789", 2));// 159246837
	}
}
