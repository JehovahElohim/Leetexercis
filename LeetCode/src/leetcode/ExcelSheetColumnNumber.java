package leetcode;

public class ExcelSheetColumnNumber {
	public int titleToNumber(String s) {
		int len = s.length() - 1;
		int sum = 0;
		for (int i = len; i >= 0; i--) {
			int temp = (int) Math.pow(26, i);
			sum += temp * (s.charAt(len - i) - 'A' + 1);
		}
		return sum;
	}
}
